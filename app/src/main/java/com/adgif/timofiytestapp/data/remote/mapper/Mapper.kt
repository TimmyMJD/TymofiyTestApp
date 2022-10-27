package com.adgif.timofiytestapp.data.remote.mapper

import com.adgif.timofiytestapp.data.remote.model.DataImageApiModel
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.data.remote.model.GifApiModel
import com.adgif.timofiytestapp.data.remote.model.OgImageApiModel
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.OgImage

fun GifApiModel.toDomain() =
    Gif(
        id = this.id,
        images = this.images.toDomain()
    )

fun DataImageApiModel.toDomain() =
    DataImage(
        ogImage = this.ogImage.toDomain()
    )

fun OgImageApiModel.toDomain() =
    OgImage(
        height = this.height,
        width = this.width,
        url = this.url
    )