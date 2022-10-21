package com.adgif.timofiytestapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class GifApiModel(
    @SerializedName("id")
    val id: String,

    @SerializedName("images")
    val images: DataImageApiModel
)

data class DataImageApiModel(
    @SerializedName("original")
    val ogImage: OgImageApiModel
)

data class OgImageApiModel(
    @SerializedName("url")
    val url: String
)