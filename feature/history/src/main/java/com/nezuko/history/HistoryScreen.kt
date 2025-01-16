package com.nezuko.history

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private const val TAG = "HistoryScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    onArrowBackClick: () -> Unit
) {
    Log.i(TAG, "HistoryScreen: ")
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
            }
        )

    }
}