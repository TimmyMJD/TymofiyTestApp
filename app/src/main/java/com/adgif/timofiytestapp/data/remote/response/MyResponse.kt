package com.adgif.timofiytestapp.data.remote.response

import com.adgif.timofiytestapp.data.remote.model.GifApiModel
import com.adgif.timofiytestapp.data.remote.model.PaginationApiModel
import com.google.gson.annotations.SerializedName

data class MyResponse(

    @SerializedName("data")
    val data: List<GifApiModel>,

    @SerializedName("pagination")
    val pagination: PaginationApiModel

)