package com.adgif.timofiytestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adgif.timofiytestapp.data.local.model.PaginationEntity

@Dao
interface PaginationDao {

    @Query("SELECT * FROM pagination WHERE id = :id")
    fun getPaginationEntity(id: String): PaginationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : PaginationEntity)
}