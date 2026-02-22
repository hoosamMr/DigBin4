package com.example.digbin0004.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.digbin0004.ui.home.HomeScreen
import com.example.digbin0004.ui.client.AddClientScreen // when you build it

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {

    val navState = rememberAppNavigationState()

    NavDisplay(
        backStack = navState.backStack,
        onBack = { navState.goBack() },
        entryProvider = entryProvider {

            entry<HomeKey> {
                HomeScreen(
                    modifier = modifier,
                    onNavigateToAddClient = {
                        navState.navigateTo(AddClientKey)
                    }
                )
            }

            entry<AddClientKey> {
                AddClientScreen(        // build this when ready
                    onBack = { navState.goBack() }
                )
            }

            // When you add more screens:
            // entry<ClientDetailKey> { entry ->
            //     ClientDetailScreen(
            //         clientId = entry.key.clientId,
            //         onBack = { navState.goBack() }
            //     )
            // }

        }
    )
}

