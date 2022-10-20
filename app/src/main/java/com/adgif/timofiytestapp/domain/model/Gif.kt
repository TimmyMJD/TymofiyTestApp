package com.adgif.timofiytestapp.domain.model

data class Gif (
    val images: DataImage
)

data class DataImage (
    val ogImage: OgImage
)

data class OgImage (
    val url: String
)