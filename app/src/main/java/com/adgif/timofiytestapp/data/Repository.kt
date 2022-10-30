package com.adgif.timofiytestapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.adgif.timofiytestapp.data.local.AppDatabase
import com.adgif.timofiytestapp.data.local.mapper.toDomain
import com.adgif.timofiytestapp.data.local.mapper.toEntity
import com.adgif.timofiytestapp.data.remote.api.ApiService
import com.adgif.timofiytestapp.data.remote.mapper.toDomain
import com.adgif.timofiytestapp.domain.IRepository
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.Pagination
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class Repository(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
) : IRepository {

    private val dataObservable = BehaviorSubject.create<List<Gif>>()
    private val trendingPageObservable = BehaviorSubject.create<Optional<Pagination>>()
    private val loadObservable = BehaviorSubject.create<Boolean>()

    init {
        Single.fromCallable {
            fetchGifsFromDB()
            fetchPaginationFromDB(PAGINATION_TRENDING_ID)
        }.subscribeOn(Schedulers.computation())
            .subscribe()
    }

    override fun loadTrending(limit: Int, offset: Int): Completable {
        return apiService.getTrending(limit = limit, offset = offset)
            .doOnSubscribe { loadObservable.onNext(true) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .doOnSuccess {
                val data = it.pagination.toDomain(PAGINATION_TRENDING_ID).toEntity()
                appDatabase.paginationDao().insert(data)

                fetchPaginationFromDB(data.id)
            }
            .doOnSuccess {
                val data = it.data.map {
                    it.toDomain().toEntity()
                }
                appDatabase.gifDao().insert(data)
                fetchGifsFromDB()
            }
            .doFinally { loadObservable.onNext(false) }
            .ignoreElement()
    }

    override fun observeTrending(): Observable<List<Gif>> = dataObservable

    override fun observeTrendingLoading(): Observable<Boolean> = loadObservable

    override fun observeTrendingPagination(): Observable<Optional<Pagination>> = trendingPageObservable

    private fun fetchGifsFromDB() {
        val mergedData = appDatabase.gifDao().getGifEntites()
        val domainMergedData = mergedData.map { it.toDomain() }

        dataObservable.onNext(domainMergedData)
    }

    private fun fetchPaginationFromDB(paginationId: String) {
        val data = appDatabase.paginationDao().getPaginationEntity(paginationId)
        val domain = data?.toDomain()

        trendingPageObservable.onNext(Optional.ofNullable(domain))
    }

    companion object {
        private const val PAGINATION_TRENDING_ID = "trending"
    }
}