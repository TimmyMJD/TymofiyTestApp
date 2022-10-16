package com.adgif.timofiytestapp.data.remote.api

import com.adgif.timofiytestapp.data.remote.response.MyResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/trending")
    fun getTrending(
        @Query("api_key") apiKey: String = "Z4pYJhdN94tVGpBb174s0KSQKnl93THL",
        @Query("limit") limit: Int = 25,
        @Query("rating") rating: String = "g"
    ): Single<MyResponse>
}