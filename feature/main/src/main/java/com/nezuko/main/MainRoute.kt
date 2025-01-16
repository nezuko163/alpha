package com.nezuko.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun MainRoute(
    onNavigateToHistory: () -> Unit,
    vm: MainViewModel = hiltViewModel()
) {
    MainScreen(
        onButtonClick = {},
        onHistoryClick = onNavigateToHistory
    )
}