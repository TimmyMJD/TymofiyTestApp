package com.adgif.timofiytestapp.data.local.mapper

import com.adgif.timofiytestapp.data.local.model.*
import com.adgif.timofiytestapp.data.remote.mapper.toDomain
import com.adgif.timofiytestapp.data.remote.model.DataImageApiModel
import com.adgif.timofiytestapp.data.remote.model.GifApiModel
import com.adgif.timofiytestapp.data.remote.model.OgImageApiModel
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.OgImage

fun GifEntity.toDomain() =
    Gif(
        images = this.images.toDomain(),
        id = this.id
    )

fun DataImageEmbedded.toDomain() =
    DataImage(
        ogImage = this.ogImage.toDomain()
    )

fun OgImageEmbedded.toDomain() =
    OgImage(
        height = this.height,
        width = this.width,
        url = this.url
    )

fun Gif.toEntity() =
    GifEntity(
        images = this.images.toEntity(),
        id = this.id
    )

fun DataImage.toEntity() =
    DataImageEmbedded(
        ogImage = this.ogImage.toEntity()
    )

fun OgImage.toEntity() =
    OgImageEmbedded(
        height = this.height,
        width = this.width,
        url = this.url
    )
