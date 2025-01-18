package com.nezuko.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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

    LaunchedEffect(binDetails) {
        if (binDetails.value.status == ResultModel.Status.FAILURE) {
            Toast.makeText(context, binDetails.value.message, Toast.LENGTH_SHORT).show()
        }
    }

    MainScreen(
        onButtonClick = {
            if (it.length < 5) {
                Toast.makeText(context, "Номер должен быть больше 5", Toast.LENGTH_SHORT).show()
            } else {
                vm.searchBin(it)
            }
        },
        onHistoryClick = onNavigateToHistory,
        binDetails = binDetails.value
    )
}