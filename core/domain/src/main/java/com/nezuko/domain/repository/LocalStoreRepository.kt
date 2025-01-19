package com.nezuko.domain.repository

import com.nezuko.domain.model.BinDetails
import kotlinx.coroutines.flow.Flow

interface LocalStoreRepository {
    fun getBins(): Flow<List<BinDetails>>

    suspend fun saveBin(vararg binDetails: BinDetails)

    suspend fun deleteAll()

    suspend fun deleteBins(vararg binDetails: BinDetails)
}