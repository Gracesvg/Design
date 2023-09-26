package com.grace.designsynergy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.data.BottomNavBar
import com.grace.designsynergy.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}

    ) {
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            AppNavHost(navController = navController)
        }

    }
}
@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomNavBar.Home,
        BottomNavBar.Professionals,
        BottomNavBar.Favourite,
        BottomNavBar.Magazine,

    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }

    }

}

@Composable
fun RowScope.AddItem(
    screen : BottomNavBar,
    currentDestination: NavDestination?,
    navController : NavHostController

){
    NavigationBarItem(
        label = { Text(text = screen.title)},
        selected = currentDestination?.hierarchy?.any{
                it.route == screen.route } == true,
        onClick = { navController.navigate(screen.route) },
        icon = { Color.DarkGray })

    }

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
