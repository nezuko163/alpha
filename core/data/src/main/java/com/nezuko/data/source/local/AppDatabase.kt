package com.nezuko.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BinEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}