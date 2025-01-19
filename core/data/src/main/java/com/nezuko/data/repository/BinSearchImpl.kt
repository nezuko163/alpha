package com.nezuko.data.repository

import android.util.Log
import com.nezuko.data.source.remote.rapid.RapidApiSource
import com.nezuko.data.source.remote.rapid.toBinDetails
import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.model.ResultModel
import com.nezuko.domain.repository.BinSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BinSearchImpl @Inject constructor(
    private val apiSource: RapidApiSource
) : BinSearch {
    private val TAG = "BinSearchImpl"
    override fun searchCardBIN(bin: String): Flow<ResultModel<BinDetails>> = flow {
        emit(ResultModel.loading())

        val binDetails = apiSource.getInfoBIN(bin)

        if (binDetails.status == ResultModel.Status.SUCCESS) {
            emit(ResultModel.success(binDetails.data!!.toBinDetails()))
            Log.i(TAG, "searchCardBIN: data - ${binDetails.data!!.toBinDetails()}")
        } else {
            Log.e(TAG, "searchCardBIN: ашипка")
            emit(ResultModel.failure(binDetails.message))
        }
    }
}