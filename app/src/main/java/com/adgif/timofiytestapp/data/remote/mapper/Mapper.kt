package com.adgif.timofiytestapp.data.remote.mapper

import com.adgif.timofiytestapp.data.remote.model.DataImageApiModel
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.data.remote.model.GifApiModel
import com.adgif.timofiytestapp.data.remote.model.OgImageApiModel
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.OgImage

fun GifApiModel.toDomain() =
    Gif(
        images = this.images.toDomain()
    )

fun OgImageApiModel.toDomain() =
    OgImage(
        url = this.url
    )

fun DataImageApiModel.toDomain() =
    DataImage(
        ogImage = this.ogImage.toDomain()
    )