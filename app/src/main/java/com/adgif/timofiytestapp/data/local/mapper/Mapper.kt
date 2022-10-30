package com.adgif.timofiytestapp.data.local.mapper

import com.adgif.timofiytestapp.data.local.model.DataImageEmbedded
import com.adgif.timofiytestapp.data.local.model.GifEntity
import com.adgif.timofiytestapp.data.local.model.OgImageEmbedded
import com.adgif.timofiytestapp.data.local.model.PaginationEntity
import com.adgif.timofiytestapp.domain.model.DataImage
import com.adgif.timofiytestapp.domain.model.Gif
import com.adgif.timofiytestapp.domain.model.OgImage
import com.adgif.timofiytestapp.domain.model.Pagination

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

fun PaginationEntity.toDomain() =
    Pagination(
        id = this.id,
        totalCount = this.totalCount,
        count = this.count,
        offset = this.offset
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

fun Pagination.toEntity() =
    PaginationEntity(
        id = this.id,
        totalCount = this.totalCount,
        count = this.count,
        offset = this.offset
    )
