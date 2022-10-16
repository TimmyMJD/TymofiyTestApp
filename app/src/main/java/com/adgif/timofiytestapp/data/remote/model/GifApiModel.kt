package com.adgif.timofiytestapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class GifApiModel (
    @SerializedName("images")
    val images: DataImage
)

data class DataImage (
    @SerializedName("original")
    val ogImage: ogImage
)

data class ogImage (
    val url: String
)