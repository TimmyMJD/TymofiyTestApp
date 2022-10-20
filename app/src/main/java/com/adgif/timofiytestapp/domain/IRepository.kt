package com.adgif.timofiytestapp.domain

import com.adgif.timofiytestapp.domain.model.Gif
import io.reactivex.Completable
import io.reactivex.Observable

interface IRepository {

    fun loadTrending(): Completable

    fun observeTrending(): Observable<List<Gif>>
}