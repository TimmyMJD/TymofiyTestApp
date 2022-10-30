package com.adgif.timofiytestapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adgif.timofiytestapp.data.local.model.GifEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface GifDao {
    @Query("SELECT * FROM gif ORDER BY auto_generate_id")
    fun getGifEntites(): List<GifEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(gifEntites : List<GifEntity>)
}