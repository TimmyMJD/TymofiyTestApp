package com.adgif.timofiytestapp.data.model

data class Gif (
    val images: DataImage
)

data class DataImage (
    val ogImage: ogImage
)

data class ogImage (
    val url: String
)