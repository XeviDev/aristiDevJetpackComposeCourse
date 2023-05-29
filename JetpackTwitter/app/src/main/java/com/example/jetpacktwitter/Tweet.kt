package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun Tweet() {

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (iconProfile, tweet) = createRefs()
        IconProfile(
            Modifier
                .constrainAs(iconProfile) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(color = Color.Red))
        TweetPart(modifier = Modifier.constrainAs(tweet) {
            top.linkTo(parent.top)
            start.linkTo(iconProfile.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
    }


}

@Composable
fun TweetPart(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (header, body) = createRefs()
        HeaderTweet(Modifier.constrainAs(header) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
        BodyTweet(Modifier.constrainAs(body) {
            top.linkTo(header.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })

    }
}

@Composable
fun BodyTweet(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (text, img) = createRefs()
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam varius nunc sed ipsum sagittis lobortis. Etiam maximus turpis ac nisl rhoncus, id euismod lorem euismod. Sed commodo risus nisi, ut cursus urna fringilla eget. Vestibulum feugiat metus non semper tincidunt. Proin facilisis rhoncus lacus ac consequat. Curabitur iaculis ligula odio, ac ultrices ex pulvinar vel. Nulla viverra neque vel porttitor dignissim. Aliquam dignissim nunc sapien, a ultrices ex gravida non. Vivamus ac tempus felis, non fringilla leo. Fusce pellentesque augue id magna vehicula ullamcorper a nec nibh. Donec eget sagittis elit. Nam quis metus non risus vestibulum laoreet ut ut sem. Mauris sollicitudin eros ac", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }, color = Color.White,
        maxLines = 5)
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "img content",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(24.dp)).height(200.dp).constrainAs(img) {
                top.linkTo(text.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })
    }
}

@Composable
fun HeaderTweet(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (name, id, options) = createRefs()
        Text("Xevi", color = Color.White, modifier = Modifier.constrainAs(name) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Text("@XeviDev 4h", color = Color(0xFF656A74), modifier = Modifier.constrainAs(id) {
            top.linkTo(parent.top)
            start.linkTo(name.end)
        })

        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "optionsTweet",
            tint = Color.White,
            modifier = Modifier.constrainAs(options) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }

        )
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



