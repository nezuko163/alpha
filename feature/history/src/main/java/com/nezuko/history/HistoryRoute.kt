package com.nezuko.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryRoute(
    onNavigateBack: () -> Unit,
    vm: HistoryViewModel = hiltViewModel()
) {
    val bins by vm.bins.collectAsState()
    HistoryScreen(
        bins = bins,
        onArrowBackClick = onNavigateBack,
        onDeleteClick = {
            vm.deleteAll()
        })
}