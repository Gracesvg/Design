package com.grace.designsynergy.screens.home

import android.support.v4.os.IResultReceiver.Default
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(){
    Box(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth()
        ){
        TopAppBar(modifier = Modifier.padding(top=24.dp),
            title ={
                Text(text = "")
            },
            actions = {
                AppBarActions()
            }
        )
    }
}

fun TopAppBar(padding: Modifier, colors: Color, title: @Composable () -> Unit, actions: @Composable() (RowScope.() -> Unit)) {


}

@Composable
fun AppBarActions(){
    SearchAction()
    ShareAction()
    PersonAction()

}


fun IconButton(onClick: () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun SearchAction(){
    val context= LocalContext.current
    IconButton(
        onClick = { Toast.makeText(context,"Search Clicked!",Toast.LENGTH_SHORT).show()
        }
    ){
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = "Search_Icon",
            tint = Color.Unspecified)
    }
}



@Composable
fun ShareAction(){
    val context= LocalContext.current
    IconButton(
        onClick = { Toast.makeText(context,"Share Clicked!",Toast.LENGTH_SHORT).show()
        }
    ){
        Icon(imageVector = Icons.Filled.Share,
            contentDescription = "Share_Icon",
            tint = Color.Unspecified)
    }
}


@Composable
fun PersonAction(){
    val context= LocalContext.current
    IconButton(
        onClick = { Toast.makeText(context,"Person Clicked!",Toast.LENGTH_SHORT).show()
        }
    ){
        Icon(imageVector = Icons.Filled.Person,
            contentDescription = "Person_Icon",
            tint = Color.Unspecified)
    }
}
@Composable
fun HomeScreen(navController: NavHostController){
    Column {
//        Text(text = "Rooms",
//            modifier = Modifier.padding(20.dp),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold, color = Color.Blue,
//            fontFamily = FontFamily.Monospace
//        )
        Spacer(modifier = Modifier.height(30.dp))


        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Row(modifier = Modifier.padding(start = 5.dp)){
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                        ){
                           Image(painter = painterResource(id = R.drawable.bathroom1),
                               contentDescription ="",
                               contentScale = ContentScale.Crop,
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .fillMaxHeight()
                                   .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                       )
                    }


                }
                Spacer(modifier = Modifier.width(10.dp))
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }


                }

            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.padding(start = 5.dp)){
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }


                Spacer(modifier = Modifier.width(10.dp))
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.padding(start = 5.dp)){
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }


                Spacer(modifier = Modifier.width(10.dp))
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.padding(start = 5.dp)){
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }


                Spacer(modifier = Modifier.width(10.dp))
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.padding(start = 5.dp)){
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }


                Spacer(modifier = Modifier.width(10.dp))
                Card() {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),

                            ){
                            Image(painter = painterResource(id = R.drawable.bathroom1),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .size(400.dp))
                        }
                        Text(text = "Olha Wood Interiors",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }

                }

            }














        }
    }
}









@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())

//    CustomAppBar()
}


