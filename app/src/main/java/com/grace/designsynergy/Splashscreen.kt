package com.grace.designsynergy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.window.SplashScreenView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Splashview:ComponentActivity(){
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Splashviewscreen()
            val mContext= LocalContext.current
            val coroutineScope= rememberCoroutineScope()
            coroutineScope.launch{
                delay(3000L)
                mContext.startActivity(Intent(mContext,MainActivity::class.java))
                finish()
            }
        }
    }
}

@Composable
fun Splashviewscreen(){
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
//        Image(painter = painterResource(id = R.drawable.images1),
//            contentDescription = "",
//            modifier = Modifier.size(250.dp),
//            contentScale = ContentScale.Fit)

        Spacer(modifier =Modifier.height(20.dp) )
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.f))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition,progress,
            modifier = Modifier.size(300.dp))

        Spacer(modifier =Modifier.height(20.dp) )
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = Color.Black,
            strokeWidth = 10.dp
        )

    }
}
@Preview(showBackground = true)
@Composable
fun SplashscreenPreview() {
    Splashview()

}