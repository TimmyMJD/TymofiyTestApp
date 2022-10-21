package com.adgif.timofiytestapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gif")
data class GifEntity(
    @PrimaryKey
    @ColumnInfo( name = "id")
    val id: Int,

    @Embedded(prefix = "images_")
    val images: DataImageEmbedded
)

data class DataImageEmbedded(
    @Embedded(prefix = "original_")
    val ogImage: OgImageEmbedded
)

data class OgImageEmbedded(
    @ColumnInfo( name = "url")
    val url: String
)