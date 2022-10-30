package com.adgif.timofiytestapp.domain.model

data class Pagination(
    val id: String,
    val totalCount: Int,
    val count: Int,
    val offset: Int
)