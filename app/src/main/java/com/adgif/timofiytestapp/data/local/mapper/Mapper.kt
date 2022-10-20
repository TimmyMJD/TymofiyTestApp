package com.adgif.timofiytestapp.data.local.mapper

import com.adgif.timofiytestapp.data.local.model.GifEntity
import com.adgif.timofiytestapp.domain.model.Gif

fun GifEntity.toDomain() =
    Gif(
        title = this.title
    )

fun Gif.toEntity() =
    GifEntity(
        title = this.title
    )
