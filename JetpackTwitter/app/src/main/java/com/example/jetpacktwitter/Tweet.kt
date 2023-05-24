package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Tweet(){
    Row(
        Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF141925)
            ).padding(16.dp)) {
        IconProfile()
        Header()
        Body()
        Footer()
    }
    
}

@Composable
fun Footer() {

}

@Composable
fun Body() {

}

@Composable
fun Header() {
    Column(Modifier.fillMaxWidth()){
        Text("Xevi", color = Color.White)
    }
}

@Composable
fun IconProfile() {
    Column() {
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = "profileImg",
            modifier = Modifier.clip(CircleShape).size(68.dp)
            )
    }
}
