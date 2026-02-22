package com.example.digbin0004.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack

class AppNavigationState(
    val backStack: NavBackStack<NavKey>
) {
    fun navigateTo(destination: AppNavKey) {
        backStack.add(destination)
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }
}

@Composable
fun rememberAppNavigationState(): AppNavigationState {
    val backStack = rememberNavBackStack(HomeKey)
    return remember { AppNavigationState(backStack) }
}