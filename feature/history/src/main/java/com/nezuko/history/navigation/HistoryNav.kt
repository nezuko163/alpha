package com.nezuko.history.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.nezuko.history.HistoryRoute
import kotlinx.serialization.Serializable

@Serializable
object History

fun NavController.navigateToHistory(
    navOptions: NavOptionsBuilder.() -> Unit = {}
) = navigate(History, navOptions)

fun NavGraphBuilder.historyScreen(
    onNavigateBack: () -> Unit,
) = composable<History>(
    enterTransition = {
        slideInHorizontally(initialOffsetX = { it })
    },
    exitTransition = {
        slideOutHorizontally(targetOffsetX = { -it })
    },
    popEnterTransition = {
        slideInHorizontally(initialOffsetX = { -it })
    },
    popExitTransition = {
        slideOutHorizontally(targetOffsetX = { it })
    }
) { backStackEntry ->
    HistoryRoute(onNavigateBack = onNavigateBack)
}