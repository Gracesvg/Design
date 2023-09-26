package com.grace.designsynergy.screens.magazine

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.R
import com.grace.designsynergy.navigation.ROUTE_BOTTOMSHEET


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MagazineScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(
                id =R.drawable.backg
            )
            ,
            contentDescription = "background", contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize()
        )
    }

    var search1 by remember { mutableStateOf("") }
     val selectedItem=remember{ mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = search1,
            onValueChange = { search1 = it },
            placeholder = { Text(text = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Magazine",
            modifier = Modifier.padding(20.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold, color = Color.White,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 25.dp, end = 25.dp)
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text(
                    text = "Need Help With Your Home Project?",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold, color = Color.Black,
                    fontFamily = FontFamily.SansSerif
                )
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Black),

                    modifier = Modifier
                        .width(200.dp)
                        .clickable {
                            navController.navigate(ROUTE_BOTTOMSHEET)
                        }

                ) {
                    Text(
                        text = "Ask a professional",
                        fontFamily = FontFamily.Monospace,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold

                    )

                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(Color.White)
                    )

                }


            }


        }

    }
    Spacer(modifier = Modifier.height(10.dp))

}







@Preview(showBackground = true)
@Composable
fun MagazineScreenPreview(){
    MagazineScreen(rememberNavController())
}


