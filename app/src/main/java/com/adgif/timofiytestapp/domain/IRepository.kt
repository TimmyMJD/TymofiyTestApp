package com.adgif.timofiytestapp.domain

import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.Pagination
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.*

interface IRepository {

    fun loadTrending(limit: Int, offset: Int): Completable

    fun observeTrending(): Observable<List<Gif>>

    fun observeTrendingLoading(): Observable<Boolean>

    fun observeTrendingPagination(): Observable<Optional<Pagination>>
}