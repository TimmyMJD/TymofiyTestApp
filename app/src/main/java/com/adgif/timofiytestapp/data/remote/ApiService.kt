package com.adgif.timofiytestapp.data.remote

import com.adgif.timofiytestapp.data.remote.pojo.MyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("gifs/trending")
    fun getTrending(
        @Query("api_key") apiKey: String = "Z4pYJhdN94tVGpBb174s0KSQKnl93THL",
        @Query("limit") limit: Int = 25,
        @Query("rating") rating: String = "g"
    ): Call<MyResponse>
}