package com.grace.designsynergy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.ui.theme.screens.SignUp.LoginScreen
import com.grace.designsynergy.screens.SignUp.SignupScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination: String= ROUTE_SIGNUP){
    NavHost(navController = navController,modifier=modifier, startDestination = startDestination) {


        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }







    }
}