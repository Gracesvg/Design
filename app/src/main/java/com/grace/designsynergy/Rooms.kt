package com.grace.designsynergy

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Rooms(){
    Card (modifier= Modifier
        .padding(8.dp)
        .clickable { }
        .fillMaxWidth(),
    ){
    Column(){
        Image(painter = painterResource(id = R.drawable.bathroom1),
            contentDescription = "Olha Wood Interiors")
        Column(modifier = Modifier.padding(16.dp)) {
//
//            Text(text = "BathRoom Interior",
//                Style=MaterialTheme.typography,)


        }

    }
    }
}
@Preview(showBackground = true)
@Composable
fun RoomsPreview(){
    Rooms()
}