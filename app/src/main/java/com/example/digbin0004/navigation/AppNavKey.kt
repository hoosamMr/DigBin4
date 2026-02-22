package com.example.digbin0004.navigation

import kotlinx.serialization.Serializable

sealed interface AppNavKey

@Serializable
data object HomeKey : AppNavKey

@Serializable
data object AddClientsKey : AppNavKey

@Serializable
data object ClientsListKey : AppNavKey



