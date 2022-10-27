package com.adgif.timofiytestapp.ui.mapper

import com.adgif.timofiytestapp.data.remote.mapper.toDomain
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.OgImage
import com.adgif.timofiytestapp.ui.model.DataImageUIModel
import com.adgif.timofiytestapp.ui.model.GifUIModel
import com.adgif.timofiytestapp.ui.model.OgImageUIModel

fun Gif.toUiModel() =
    GifUIModel(
        images = this.images.toUiModel(),
        id = this.id
    )

fun DataImage.toUiModel() =
    DataImageUIModel(
        ogImage = this.ogImage.toUiModel()
    )

fun OgImage.toUiModel() =
    OgImageUIModel(
        height = this.height,
        width = this.width,
        url = this.url
    )