package com.example.teledoneandroid

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route + "/test") {
        composable(
            route = Screen.MainScreen.route + "/{title}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = "Test title"
                    nullable = true
                }
            )
        ) { entry ->
            ComposeTeledoneApp(
                navController = navController,
                title = entry.arguments?.getString("title"),
            )
        }

        composable(route = Screen.NewTaskScreen.route) {
            NewTaskLayout(navController = navController)
        }
    }
}