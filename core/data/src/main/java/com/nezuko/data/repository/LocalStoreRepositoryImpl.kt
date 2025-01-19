package com.nezuko.data.repository

import com.nezuko.data.source.local.BinDao
import com.nezuko.data.source.local.BinEntity
import com.nezuko.data.source.local.toBinEntity
import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.repository.LocalStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalStoreRepositoryImpl @Inject constructor(
    private val binDao: BinDao
) : LocalStoreRepository {

    override suspend fun saveBin(vararg binDetails: BinDetails) =
        binDao.insertBins(*binDetails.map { it.toBinEntity() }.toTypedArray())

    override suspend fun deleteAll() =
        binDao.deleteAll()


    override fun getBins(): Flow<List<BinDetails>> =
        binDao.getAll().map { it.map(BinEntity::toBinDetails) }

}