package com.adgif.timofiytestapp.domain.model

data class Gif(
    val id: String,
    val images: DataImage
)

data class DataImage(
    val ogImage: OgImage
)

data class OgImage(
    val height: String,
    val width: String,
    val url: String
)