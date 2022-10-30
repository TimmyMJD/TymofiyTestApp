package com.adgif.timofiytestapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class PaginationApiModel(
    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("offset")
    val offset: Int
)