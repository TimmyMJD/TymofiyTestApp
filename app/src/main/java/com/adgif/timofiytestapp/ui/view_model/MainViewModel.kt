package com.adgif.timofiytestapp.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adgif.timofiytestapp.data.remote.ApiService
import com.adgif.timofiytestapp.data.remote.pojo.MyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {

    val dataLiveData = MutableLiveData<List<String>>()

    private val BASE_URL = "https://api.giphy.com/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    init {

        apiService.getTrending().enqueue(object : Callback<MyResponse> {
            override fun onResponse(call: Call<MyResponse>, response: Response<MyResponse>) {
                if (response.isSuccessful) {
                    dataLiveData.value = response.body()?.data?.map { it.title } ?: emptyList()
                }
            }

            override fun onFailure(call: Call<MyResponse>, t: Throwable?) {
                t?.message
                // DO failure handling
            }
        })
    }


}