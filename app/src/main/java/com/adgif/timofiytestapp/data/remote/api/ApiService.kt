package com.adgif.timofiytestapp.data.remote.api

import com.adgif.timofiytestapp.data.remote.response.MyResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/trending")
    fun getTrending(
        @Query("api_key") apiKey: String = "Z4pYJhdN94tVGpBb174s0KSQKnl93THL",
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String = "g"
    ): Single<MyResponse>

    @GET("gifs/search")
    fun getSearch(
        @Query("api_key") apiKey: String = "Z4pYJhdN94tVGpBb174s0KSQKnl93THL",
        @Query("q") query: String = "",
        @Query("limit") limit: Int = 25,
        @Query("offset") offset: Int = 0,
        @Query("rating") rating: String = "g",
        @Query("lang") language: String = "en"
    ): Single<MyResponse>
}