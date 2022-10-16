package com.adgif.timofiytestapp.data.remote.mapper

import com.adgif.timofiytestapp.data.model.Gif
import com.adgif.timofiytestapp.data.remote.model.GifApiModel

fun GifApiModel.toDomain() =
    Gif(
        title = this.title
    )

fun Gif.toApiModel() =
    GifApiModel(
        title = this.title
    )