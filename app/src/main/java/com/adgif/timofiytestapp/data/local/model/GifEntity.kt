package com.adgif.timofiytestapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gif")
data class GifEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "auto_generate_id")
    var autoGenerateId: Int? = null,

    @ColumnInfo(name = "id")
    val id: String,

    @Embedded(prefix = "images_")
    val images: DataImageEmbedded
)

data class DataImageEmbedded(
    @Embedded(prefix = "original_")
    val ogImage: OgImageEmbedded
)

data class OgImageEmbedded(
    @ColumnInfo(name = "height")
    val height: String,

    @ColumnInfo(name = "width")
    val width: String,

    @ColumnInfo(name = "url")
    val url: String
)