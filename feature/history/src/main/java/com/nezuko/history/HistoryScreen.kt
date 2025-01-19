package com.nezuko.history

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nezuko.domain.model.BinDetails
import com.nezuko.history.components.BINCard
import com.nezuko.ui.theme.Spacing

private const val TAG = "HistoryScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    onArrowBackClick: () -> Unit,
    onDeleteClick: () -> Unit,
    bins: List<BinDetails>
) {
    Log.i(TAG, "HistoryScreen: ")
    val scrollState = rememberScrollState()

    Column {
        TopAppBar(
            title = { Text(text = "История") },
            navigationIcon = {
                IconButton(onClick = onArrowBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            actions = {
                IconButton(onClick = onDeleteClick) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                }
            }
        )

        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            bins.forEach { bin ->
                BINCard(
                    binDetails = bin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Spacing.default.small)
                )
            }
        }

    }
}