package com.adgif.timofiytestapp.data

import com.adgif.timofiytestapp.data.model.Gif
import io.reactivex.Completable
import io.reactivex.Observable

interface IRepository {

    fun loadTrending(): Completable

    fun observeTrending(): Observable<List<Gif>>
}