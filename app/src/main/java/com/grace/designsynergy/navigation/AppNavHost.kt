package com.grace.designsynergy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.data.BottomNavBar
import com.grace.designsynergy.screens.project.AddProjectsScreen
import com.grace.designsynergy.screens.project.UpdateProductsScreen
import com.grace.designsynergy.ui.theme.screens.SignUp.LoginScreen
import com.grace.designsynergy.screens.SignUp.SignupScreen
import com.grace.designsynergy.screens.bookmarks.BookmarkScreen
import com.grace.designsynergy.screens.home.HomeScreen
import com.grace.designsynergy.screens.magazine.MagazineScreen
import com.grace.designsynergy.screens.popupmenu.PopupMenu
import com.grace.designsynergy.screens.professionals.ProfessionalsScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUTE_SIGNUP){
    NavHost(navController = navController,modifier=modifier, startDestination = BottomNavBar.Home.route) {

        composable(route = BottomNavBar.Home.route) {
            HomeScreen(rememberNavController())
        }

        composable(route=BottomNavBar.Professionals.route) {
            ProfessionalsScreen(rememberNavController())
        }

        composable(route=BottomNavBar.Magazine.route) {
            MagazineScreen(rememberNavController())
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_ADDPROJECT) {
            AddProjectsScreen(navController)
        }
        composable(ROUTE_UPDATEPROJECT) {
            UpdateProductsScreen(navController,id= "")
        }
        composable(ROUTE_POPUPMENU) {
            PopupMenu(navController)
        }
        composable(ROUTE_UPLOADSCREEN) {
            PopupMenu(navController)
        }




















    }
}





