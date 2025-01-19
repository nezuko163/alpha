package com.nezuko.history.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nezuko.domain.model.BinDetails
import com.nezuko.ui.theme.Spacing

@Composable
fun BINCard(
    modifier: Modifier = Modifier,
    binDetails: BinDetails
) {
    ElevatedCard(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Бренд карты")
                Text(text = binDetails.cardBrand.ifEmpty { "Неизвестен" })

                Spacer(modifier = Modifier.padding(Spacing.default.small))

                Text(text = "Тип карты")
                Text(text = binDetails.typeCard.ifEmpty { "Неизвестен" })

                Spacer(modifier = Modifier.padding(Spacing.default.small))

                Text(text = "Название банка")
                Text(text = binDetails.bankName.ifEmpty { "Неизвестно" })

                Spacer(modifier = Modifier.padding(Spacing.default.small))

                Text(text = "Ссылка банка")
                Text(text = binDetails.bankUrl)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Телефон банка")
                Text(text = binDetails.bankPhone)


                Spacer(modifier = Modifier.padding(Spacing.default.small))

                Text(text = "Страна")
                Text(text = binDetails.country)

                Spacer(modifier = Modifier.padding(Spacing.default.small))

                Text(text = "Флаг страны")
                Text(text = binDetails.flagCountry)
            }
        }
    }
}