package com.grace.designsynergy

//package com.example.jetpackcomposecourseoutline

    import android.annotation.SuppressLint
    import android.content.Intent
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.material3.CircularProgressIndicator
    import androidx.compose.material3.LinearProgressIndicator
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.rememberCoroutineScope
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
    import com.airbnb.lottie.compose.LottieAnimation
    import com.airbnb.lottie.compose.LottieCompositionSpec
    import com.airbnb.lottie.compose.animateLottieCompositionAsState
    import com.airbnb.lottie.compose.rememberLottieComposition
    import kotlinx.coroutines.delay
    import kotlinx.coroutines.launch

class Splashscreen: ComponentActivity() {
        @SuppressLint("CoroutineCreationDuringComposition")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                SplashScreen()

                val mContext = LocalContext.current
                val coroutineScope = rememberCoroutineScope()
                coroutineScope.launch{
                    delay(1000)
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))
                    finish()

                }
            }
        }
    }

    @Composable
    fun SplashScreen() {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//        Image(
//            painter = painterResource(id = R.drawable.images1),
//            contentDescription = "",
//            modifier = Modifier.size(200.dp),
//            contentScale = ContentScale.Fit
//        )


            Spacer(modifier = Modifier.height(10.dp))

            //Lottie Animation
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.intro))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(composition, progress,
                modifier = Modifier.size(600.dp)
            )

            Text(
                text = "Welcome",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))


            //CircularProgressIndicator
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                color = Color.Black,
                strokeWidth = 10.dp
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun workPreview(){
        SplashScreen()

}

