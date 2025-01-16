package com.nezuko.main.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.nezuko.main.MainRoute
import kotlinx.serialization.Serializable

@Serializable
object Main

fun NavController.navigateToMain(
    navOptions: NavOptionsBuilder.() -> Unit = {}
) = navigate(Main, navOptions)

fun NavGraphBuilder.mainScreen(
    onNavigateToHistory: () -> Unit
) = composable<Main>(
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
    MainRoute(onNavigateToHistory = onNavigateToHistory)
}