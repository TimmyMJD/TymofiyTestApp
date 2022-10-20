package com.adgif.timofiytestapp.data

import com.adgif.timofiytestapp.data.local.AppDatabase
import com.adgif.timofiytestapp.data.local.mapper.toDomain
import com.adgif.timofiytestapp.data.local.mapper.toEntity
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.data.remote.api.ApiService
import com.adgif.timofiytestapp.data.remote.mapper.toDomain
import com.adgif.timofiytestapp.domain.IRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class Repository(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
) : IRepository {

    private val dataObservable = BehaviorSubject.create<List<Gif>>()

    init {
        Single.fromCallable {
            fetchDataFromDB()
        }.subscribeOn(Schedulers.computation())
            .subscribe()
    }

    override fun loadTrending(): Completable {
        return apiService.getTrending()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .doOnSuccess {
                val data = it.data.map {
                    it.toDomain().toEntity()
                }
                appDatabase.gifDao().insert(data)
                fetchDataFromDB()
            }
            .ignoreElement()
    }

    override fun observeTrending(): Observable<List<Gif>> = dataObservable

    private fun fetchDataFromDB() {
        val mergedData = appDatabase.gifDao().getGifEntites()
        val domainMergedData = mergedData.map { it.toDomain() }

        dataObservable.onNext(domainMergedData)
    }
}