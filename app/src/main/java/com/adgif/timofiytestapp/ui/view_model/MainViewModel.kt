package com.adgif.timofiytestapp.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adgif.timofiytestapp.domain.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: IRepository
) : ViewModel() {

    val dataLiveData = MutableLiveData<List<String>>()

//    SingleLiveEvent for error message
    private val disposables = CompositeDisposable()

    init {
        repository.observeTrending()
            .doOnNext {
                dataLiveData.postValue(it.map { it.title })
            }
            .subscribe()
            .let { disposables.add(it) }

        repository.loadTrending()
            .onErrorComplete {
                true
            }
            .subscribe()
            .let { disposables.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}