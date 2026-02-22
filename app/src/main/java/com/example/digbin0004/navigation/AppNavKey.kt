package com.example.digbin0004.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppNavKey : NavKey


@Serializable
data object HomeKey : AppNavKey

@Serializable
data object AddClientKey : AppNavKey






