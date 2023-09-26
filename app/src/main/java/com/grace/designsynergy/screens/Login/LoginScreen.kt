package com.grace.designsynergy.ui.theme.screens.SignUp

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.grace.designsynergy.R
import com.grace.designsynergy.data.AuthViewModel
import com.grace.designsynergy.navigation.ROUTE_HOME
import com.grace.designsynergy.navigation.ROUTE_LOGIN
import com.grace.designsynergy.navigation.ROUTE_SIGNUP


@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var Email by remember { mutableStateOf(TextFieldValue("")) }
    var Password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .padding(top = 20.dp)
            .verticalScroll(rememberScrollState())



        )
    {

        Spacer(modifier = Modifier.height(50.dp))

        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation))
        val progress by animateLottieCompositionAsState(composition )

        LottieAnimation(composition, progress,
            modifier = Modifier.size(380.dp))

        TextField(value = Email,
            onValueChange = { Email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 14.dp),
            colors = TextFieldDefaults.run {
                textFieldColors(
                    textColor = Color.Black,
                    focusedIndicatorColor=Color.Transparent,
                    unfocusedIndicatorColor= Color.Transparent)
            },

            singleLine = true,
            leadingIcon = {
                Row (
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.email),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color.White)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Email")},
            placeholder = {
                Text(text = "")
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace
            )
        )
        TextField(value = Password,
            onValueChange = { Password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 14.dp),
            colors = TextFieldDefaults.run {
                textFieldColors(
                    textColor = Color.Black,
                    focusedIndicatorColor=Color.Transparent,
                    unfocusedIndicatorColor= Color.Transparent)
            },

            singleLine = true,
            leadingIcon = {
                Row (
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.password),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))
                    Spacer(modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color.White)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Password")},
            placeholder = {
                Text(text = "")
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace
            )
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            val mylogin = AuthViewModel(navController, context )
            mylogin.login(Email.text.trim(),Password.text.trim())
            navController.navigate(ROUTE_HOME)

        },
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.width(300.dp),
        ) {
            Text(text = "Login",
                fontFamily = FontFamily.Monospace,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold)
        }
        Row {
            Text(text = "Need an Account? ",
                fontSize = 15.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "SIGN UP",
                modifier = Modifier.clickable {
                    navController.navigate(ROUTE_SIGNUP)
                })
        }
    }
}
@Preview


@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}

