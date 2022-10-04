package com.adgif.timofiytestapp.data.remote.pojo

import com.google.gson.annotations.SerializedName

data class MyResponse (
    @SerializedName("data")
    val data: List<Gif>

)