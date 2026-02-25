package com.example.digbin0004.ui.home


import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.digbin0004.navigation.AddClientKey
import com.example.digbin0004.navigation.AppNavKey
import com.example.digbin0004.navigation.HomeKey

@Composable
fun MyNavBar(
    selectedRoute: AppNavKey,
    onRouteSelected : (AppNavKey) -> Unit,
    modifier: Modifier = Modifier,

){
    val tabs = listOf(
        //NavBarItem("Home", HomeKey),
        NavBarItem("Clients", AddClientKey)

    )

    NavigationBar(modifier = modifier) {
        tabs.forEach {item ->
            NavigationBarItem(
                selected = selectedRoute ==item.key,
                onClick = {onRouteSelected(item.key)},
                icon = {},
                label = {Text(item.title)},
                alwaysShowLabel = true
            )

        }
    }
}

data class NavBarItem(
    val title: String,
    val key : AppNavKey
    //val route: String
)