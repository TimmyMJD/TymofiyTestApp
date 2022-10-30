package com.adgif.timofiytestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adgif.timofiytestapp.data.local.dao.GifDao
import com.adgif.timofiytestapp.data.local.dao.PaginationDao
import com.adgif.timofiytestapp.data.local.model.GifEntity
import com.adgif.timofiytestapp.data.local.model.PaginationEntity

@Database(entities = [GifEntity::class, PaginationEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "main.db"
    }

    abstract fun gifDao(): GifDao

    abstract fun paginationDao(): PaginationDao
}