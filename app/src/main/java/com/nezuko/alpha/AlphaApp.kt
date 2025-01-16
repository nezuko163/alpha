package com.nezuko.alpha

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.nezuko.history.navigation.historyScreen
import com.nezuko.history.navigation.navigateToHistory
import com.nezuko.main.navigation.Main
import com.nezuko.main.navigation.mainScreen

@Composable
fun AlphaApp(
    startDestination: Any = Main,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popExitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None }
    ) {
        mainScreen(onNavigateToHistory = {
            navController.navigateToHistory()
        })

        historyScreen(onNavigateBack = {
            navController.popBackStack()
        })
    }
}

