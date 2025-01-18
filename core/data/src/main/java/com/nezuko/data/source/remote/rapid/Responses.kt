package com.nezuko.data.source.remote.rapid

import com.nezuko.domain.model.BinDetails
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val code: Int,
    val BIN: BinInfo
)

@Serializable
data class BinInfo(
    val valid: Boolean,
    val number: Int,
    val length: Int,
    val scheme: String,
    val brand: String,
    val type: String,
    val level: String?,
    val is_commercial: String,
    val is_prepaid: String,
    val currency: String,
    val issuer: Issuer,
    val country: Country
)

@Serializable
data class Issuer(
    val name: String?,
    val website: String?,
    val phone: String?
)

@Serializable
data class Country(
    val name: String,
    val native: String,
    val flag: String,
    val numeric: String,
    val capital: String,
    val currency: String,
    val currency_name: String,
    val currency_symbol: String,
    val region: String,
    val subregion: String,
    val idd: String,
    val alpha2: String,
    val alpha3: String,
    val language: String,
    val language_code: String
)

fun ApiResponse.toBinDetails(): BinDetails {
    return BinDetails(
        bin = this.BIN.number,
        cardBrand = this.BIN.brand.ifEmpty { "Неизвестен" },
        typeCard = this.BIN.type.ifEmpty { "Неизвестен" },
        bankName = (this.BIN.issuer.name ?: "Неизвестен").ifEmpty { "Неизвестен" },
        bankUrl = (this.BIN.issuer.website ?: "Неизвестен").ifEmpty { "Неизвестен" },
        bankPhone = (this.BIN.issuer.phone ?: "Неизвестен").ifEmpty { "Неизвестен" },
        country = this.BIN.country.name.ifEmpty { "Неизвестен" },
        flagCountry = this.BIN.country.flag.ifEmpty { "Неизвестен" }
    )
}