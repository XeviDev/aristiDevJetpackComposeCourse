package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Tweet() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (iconProfile, body, header, tweet, img, bottomIcons) = createRefs()
        IconProfile(Modifier.constrainAs(iconProfile) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)

        })
        HeaderTweet(Modifier.constrainAs(body) {
            start.linkTo(iconProfile.end)
            top.linkTo(iconProfile.top)
        })
    }

}
@Composable
fun HeaderTweet(modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text("Xevi", color = Color.White)
        Text("@XeviDev 4h", color = Color(0xFF656A74))
        Column() {
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "optionsTweet",
                tint = Color.White,
                modifier = modifier.align(Alignment.End)

            )
        }

    }


}

@Composable
fun IconProfile(modifier: Modifier) {

    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profileImg",
        modifier = modifier
            .clip(CircleShape)
            .size(68.dp)
    )

}



