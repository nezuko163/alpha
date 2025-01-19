package com.nezuko.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nezuko.domain.model.BinDetails

@Entity(tableName = "bins")
data class BinEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "bin")
    val bin: Int,

    @ColumnInfo(name = "card_brand")
    val cardBrand: String,

    @ColumnInfo(name = "type_card")
    val typeCard: String,

    @ColumnInfo(name = "bank_name")
    val bankName: String,

    @ColumnInfo(name = "bank_url")
    val bankUrl: String,

    @ColumnInfo(name = "bank_phone")
    val bankPhone: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "flag_country")
    val flagCountry: String,
) {
    fun toBinDetails(): BinDetails {
        return BinDetails(
            bin = this.bin,
            cardBrand = this.cardBrand,
            typeCard = this.typeCard,
            bankName = this.bankName,
            bankUrl = this.bankUrl,
            bankPhone = this.bankPhone,
            country = this.country,
            flagCountry = this.flagCountry
        )
    }
}

fun BinDetails.toBinEntity(): BinEntity {
    return BinEntity(
        bin = this.bin,
        cardBrand = this.cardBrand,
        typeCard = this.typeCard,
        bankName = this.bankName,
        bankUrl = this.bankUrl,
        bankPhone = this.bankPhone,
        country = this.country,
        flagCountry = this.flagCountry
    )
}
