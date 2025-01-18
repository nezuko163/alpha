package com.nezuko.data.source.remote

import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.model.ResultModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.request
import javax.inject.Inject

class ApiRemoteSource @Inject constructor(
    private val httpClient: HttpClient
) {


//    suspend fun getInfoBIN(bin: Int): ResultModel<BinDetails> {
//        val request = httpClient.get("https://lookup.binlist.net/$bin") {
//            header(
//                "User-Agent",
//                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 YaBrowser/24.7.0.0 Safari/537.36"
//            )
//        }
//
//    }
}