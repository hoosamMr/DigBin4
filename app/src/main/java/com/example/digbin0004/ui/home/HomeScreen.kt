package com.example.digbin0004.ui.home

import com.example.digbin0004.ui.client.ClientsListScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

enum class HomeTab {
    CLIENTS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToAddClient: () -> Unit  // ← add this
) {
    var selectedTab by remember { mutableStateOf(HomeTab.CLIENTS) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("DigBin") })
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == HomeTab.CLIENTS,
                    onClick = { selectedTab = HomeTab.CLIENTS },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Clients"
                        )
                    },
                    label = { Text("Clients") }
                )
            }
        },
        floatingActionButton = {
            // FAB lives here — triggers AddClient however you decide (screen or bottom sheet)
            FloatingActionButton(onClick = onNavigateToAddClient) {
                Icon(Icons.Default.Add, contentDescription = "Add Client")
            }
        }
    ) { padding ->
        when (selectedTab) {
            HomeTab.CLIENTS -> {
                ClientsListScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                )
            }
        }
    }
}