package com.example.teledoneandroid

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object NewTaskScreen : Screen("new_task_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}