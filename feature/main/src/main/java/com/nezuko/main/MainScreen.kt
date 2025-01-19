package com.nezuko.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nezuko.domain.model.BinDetails
import com.nezuko.domain.model.ResultModel
import com.nezuko.ui.theme.LightBlue
import com.nezuko.ui.theme.Spacing

private const val TAG = "MainScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onButtonClick: (String) -> Unit,
    onHistoryClick: () -> Unit,
    binDetails: ResultModel<BinDetails>,
) {
    var text by rememberSaveable { mutableStateOf("") }
    Log.i(TAG, "MainScreen: ")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "Главная") },
            actions = {
                IconButton(onClick = onHistoryClick) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.default.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(Spacing.default.small),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = White,
                    focusedContainerColor = White,
                    disabledContainerColor = White
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "поиск")
                }
            )

            Button(
                onClick = { onButtonClick(text) },
                modifier = Modifier
                    .padding(Spacing.default.small)
                    .height(IntrinsicSize.Max),
                shape = RoundedCornerShape(20.dp),
                enabled = binDetails.status != ResultModel.Status.LOADING,
                colors = ButtonDefaults.buttonColors(containerColor = LightBlue)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "кнопка"
                )
            }
        }

        if (binDetails.status == ResultModel.Status.SUCCESS) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "Бренд карты")
                    Text(text = binDetails.data!!.cardBrand.ifEmpty { "Неизвестен" })

                    Spacer(modifier = Modifier.padding(Spacing.default.small))

                    Text(text = "Тип карты")
                    Text(text = binDetails.data!!.typeCard.ifEmpty { "Неизвестен" })

                    Spacer(modifier = Modifier.padding(Spacing.default.small))

                    Text(text = "Название банка")
                    Text(text = binDetails.data!!.bankName.ifEmpty { "Неизвестно" })

                    Spacer(modifier = Modifier.padding(Spacing.default.small))

                    Text(text = "Ссылка банка")
                    Text(text = binDetails.data!!.bankUrl)
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Телефон банка")
                    Text(text = binDetails.data!!.bankPhone)


                    Spacer(modifier = Modifier.padding(Spacing.default.small))

                    Text(text = "Страна")
                    Text(text = binDetails.data!!.country)

                    Spacer(modifier = Modifier.padding(Spacing.default.small))

                    Text(text = "Флаг страны")
                    Text(text = binDetails.data!!.flagCountry)
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainPreview() {
    MainScreen({}, {}, ResultModel.none())
}