package com.adgif.timofiytestapp.data.remote.mapper

import com.adgif.timofiytestapp.data.remote.model.DataImageApiModel
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.data.remote.model.GifApiModel
import com.adgif.timofiytestapp.data.remote.model.OgImageApiModel
import com.adgif.timofiytestapp.data.remote.model.PaginationApiModel
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.OgImage
import com.adgif.timofiytestapp.domain.model.Pagination

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

fun PaginationApiModel.toDomain(id: String) =
    Pagination(
        id = id,
        totalCount = this.totalCount,
        count = this.count,
        offset = this.offset
    )