package com.adgif.timofiytestapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gif")
data class GifEntity (
    @PrimaryKey
    val images: DataImage
)


data class DataImage (
    val ogImage: OgImage
)

data class OgImage (
    val url: String
)