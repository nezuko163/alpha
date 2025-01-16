package com.nezuko.history

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HistoryRoute(
    onNavigateBack: () -> Unit,
    vm: HistoryViewModel = hiltViewModel()
) {
    HistoryScreen(onArrowBackClick = onNavigateBack)
}