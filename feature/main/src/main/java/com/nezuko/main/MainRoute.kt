package com.nezuko.main

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.nezuko.domain.model.ResultModel

private const val TAG = "MainRoute"

@Composable
fun MainRoute(
    onNavigateToHistory: () -> Unit,
    vm: MainViewModel = hiltViewModel()
) {
    val binDetails = vm.binDetails.collectAsState()
    val context = LocalContext.current

    MainScreen(
        onButtonClick = {
            if (it.length < 6) {
                Toast.makeText(context, "Номер должен быть больше 5", Toast.LENGTH_SHORT).show()
            } else {
                vm.searchBin(
                    bin = it,
                    onFailure = { str ->
                        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        },
        onHistoryClick = onNavigateToHistory,
        binDetails = binDetails.value
    )
}