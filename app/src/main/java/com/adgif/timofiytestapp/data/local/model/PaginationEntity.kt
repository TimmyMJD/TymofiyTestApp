package com.adgif.timofiytestapp.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pagination")
data class PaginationEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "total_count")
    val totalCount: Int,

    @ColumnInfo(name = "count")
    val count: Int,

    @ColumnInfo(name = "offset")
    val offset: Int
)