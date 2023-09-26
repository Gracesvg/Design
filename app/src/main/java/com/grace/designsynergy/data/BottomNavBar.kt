package com.grace.designsynergy.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBar(
    val route:String,
    val title:String,
    val icon:ImageVector,
){
    object Home:BottomNavBar(
        route="Home",
        title="Home",
        icon=Icons.Default.Home,

    )
    object Professionals:BottomNavBar(
        route="Professionals",
        title="Professionals",
        icon=Icons.Default.MailOutline,
        )
    object Favourite:BottomNavBar(
        route="Favourite",
        title="Favourite",
        icon=Icons.Default.FavoriteBorder,

        )
    object Magazine:BottomNavBar(
        route="Magazine",
        title="Magazine",
        icon=Icons.Default.List,

        )





}
