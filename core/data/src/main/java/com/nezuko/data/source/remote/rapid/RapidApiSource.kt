package com.nezuko.data.source.remote.rapid

import android.util.Log
import com.nezuko.domain.model.ResultModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class RapidApiSource @Inject constructor(
    private val httpClient: HttpClient
) {
    private val TAG = "RapidApiSource"
    suspend fun getInfoBIN(bin: String): ResultModel<ApiResponse> {
        try {
            val jsonBody = """
                {"bin":"448590"}
            """.trimIndent()

            val request = httpClient.post("https://bin-ip-checker.p.rapidapi.com") {
                headers {
                    append(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 YaBrowser/24.7.0.0 Safari/537.36"
                    )
                    append("x-rapidapi-key", "4e6de3973emsh1099471a4e45b50p17445djsn617ba1dbaf41")
                    append("x-rapidapi-host", "bin-ip-checker.p.rapidapi.com")
                    append("Content-Type", "application/json")
                }
                contentType(ContentType.Application.Json)
                setBody(jsonBody)
                parameter("bin", bin)
            }
            Log.i(TAG, "getInfoBIN: code - ${request.status.value}")

            return when (request.status.value) {
                in 200..299 -> {
                    val body: ApiResponse = request.body()
                    Log.i(TAG, "getInfoBIN: data - $body")
                    ResultModel.success(body)
                }

                404 -> {
                    Log.i(TAG, "getInfoBIN: The BIN number doesn't exist!")
                    ResultModel.failure("Не существует BIN номера")
                }

                else -> {
                    Log.e(TAG, "getInfoBIN: Ошибка")
                    Log.e(TAG, "body - ${request.body<String>()}")
                    ResultModel.failure("Неизвестная ошибка")
                }
            }

        } catch (e: Exception) {
            Log.e(TAG, "getInfoBIN: ", e)
            return ResultModel.failure(e.message)
        }
    }
}