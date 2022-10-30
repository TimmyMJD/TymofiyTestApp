package com.adgif.timofiytestapp.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adgif.timofiytestapp.domain.IRepository
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.Pagination
import com.adgif.timofiytestapp.ui.mapper.toUiModel
import com.adgif.timofiytestapp.ui.model.GifUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: IRepository
) : ViewModel() {

    val dataLiveData = MutableLiveData<List<GifUIModel>>()
    val trendingLoadingLiveData = MutableLiveData<Boolean>()
    private val trendingPaginationLiveData = MutableLiveData<Optional<Pagination>>()

    //    SingleLiveEvent for error message
    private val disposables = CompositeDisposable()

    init {
        repository.observeTrending()
            .doOnNext {
                dataLiveData.postValue(it.map { it.toUiModel() })
            }
            .subscribe()
            .let { disposables.add(it) }

        repository.observeTrendingLoading()
            .doOnNext(trendingLoadingLiveData::postValue)
            .subscribe()
            .let { disposables.add(it) }

        repository.observeTrendingPagination()
            .doOnNext(trendingPaginationLiveData::postValue)
            .subscribe()
            .let { disposables.add(it) }

        repository.observeTrendingPagination()
            .firstOrError()
            .doOnSuccess {
                loadMore(it)
            }
            .subscribe()
            .let { disposables.add(it) }
    }

    fun loadMore(optPagination: Optional<Pagination>? = trendingPaginationLiveData.value) {
        val pagination = optPagination?.orElseGet { null }
        val count = getPageSize()
        val offset = pagination?.offset ?: 0
        repository.loadTrending(limit = count, offset = count + offset)
            .onErrorComplete {
                true
            }
            .subscribe()
            .let { disposables.add(it) }
    }

    fun getPageSize() = trendingPaginationLiveData.value?.get()?.count ?: PAGE_SIZE

    fun isLoading(): Boolean = trendingLoadingLiveData.value ?: false

    fun isLastPage(): Boolean = trendingPaginationLiveData.value?.get()?.run {
        offset + count >= totalCount
    } ?: false

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    companion object {
        private const val PAGE_SIZE = 5
    }
}