package com.grace.designsynergy.screens.popupmenu

import android.content.res.Configuration
import android.widget.PopupMenu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.ui.theme.DesignSynergyTheme

@Composable
fun PopupMenu(navController: NavHostController){
    LazyColumn(modifier = Modifier.fillMaxSize()
        .fillMaxHeight(),
    verticalArrangement = Arrangement.spacedBy(150.dp)){
        item (7){
            Text(text = "Item:")

            Text(text = "Item:")
            Text(text = "Item:")
            Text(text = "Item:")
            Text(text = "Item:")
            Text(text = "Item:")
            Text(text = "Item:")
            Text(text = "Item:")

        }
    }
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PopupMenuPreview(){
    DesignSynergyTheme {
        PopupMenu(rememberNavController())
    }
}