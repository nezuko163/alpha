package com.nezuko.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {
    @Query("SELECT * FROM bins")
    fun getAll(): Flow<List<BinEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBins(vararg bins: BinEntity)

    @Query("DELETE FROM bins")
    suspend fun deleteAll()
}