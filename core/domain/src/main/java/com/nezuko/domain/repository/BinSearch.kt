package com.nezuko.domain.repository

import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.model.ResultModel
import kotlinx.coroutines.flow.Flow

interface BinSearch {
    fun searchCardBIN(bin: String): Flow<ResultModel<BinDetails>>
}