package com.adgif.timofiytestapp.ui.model

data class GifUIModel(
    val id: String,
    val images: DataImageUIModel
)

data class DataImageUIModel(
    val ogImage: OgImageUIModel
)

data class OgImageUIModel(
    val url: String
)