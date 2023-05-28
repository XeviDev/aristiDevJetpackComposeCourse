package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Tweet() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (iconProfile, tweet) = createRefs()
        IconProfile(Modifier.constrainAs(iconProfile){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }.background(color = Color.Red))
        TweetPart(Modifier.constrainAs(tweet){
            top.linkTo(parent.top)
            start.linkTo(iconProfile.end)
            end.linkTo(parent.end)
        }.background(color = Color.Green))
    }


}

@Composable
fun TweetPart(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (header) = createRefs()
        HeaderTweet(Modifier.constrainAs(header){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

    }
}

@Composable
fun HeaderTweet(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val(name, id, options) = createRefs()
        Text("Xevi", color = Color.White, modifier = Modifier.constrainAs(name){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Text("@XeviDev 4h", color = Color(0xFF656A74), modifier = Modifier.constrainAs(id){
            top.linkTo(parent.top)
            start.linkTo(name.end)
        })

        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "optionsTweet",
            tint = Color.White,
            modifier = Modifier.constrainAs(options){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }

        )
    }





}

@Composable
fun IconProfile(modifier: Modifier) {
ConstraintLayout() {
    val (icon) = createRefs()
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profileImg",
        modifier = modifier
            .clip(CircleShape)
            .size(68.dp)
            .constrainAs(icon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
    )

}



}



