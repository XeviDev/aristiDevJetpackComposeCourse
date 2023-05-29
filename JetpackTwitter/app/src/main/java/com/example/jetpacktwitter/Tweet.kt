package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
        val (iconProfile, tweet, divider) = createRefs()
        IconProfile(
            Modifier
                .constrainAs(iconProfile) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        TweetPart(modifier = Modifier
            .constrainAs(tweet) {
                top.linkTo(parent.top)
                start.linkTo(iconProfile.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .background(color = Color.Green))
        Divider(
            Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .constrainAs(divider) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(tweet.bottom)
                })
    }


}

@Composable
fun TweetPart(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (header, body, footer) = createRefs()
        HeaderTweet(Modifier.constrainAs(header) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
        BodyTweet(Modifier.constrainAs(body) {
            top.linkTo(header.bottom)
            start.linkTo(parent.start)
            bottom.linkTo(footer.top)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        })
        FooterTweet(Modifier.constrainAs(footer) {
            top.linkTo(body.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
        })

    }
}

@Composable
fun FooterTweet(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (comment, rt, like) = createRefs()
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = "optionsTweet",
            tint = Color.White,
            modifier = Modifier.constrainAs(comment) {
//                start.linkTo(parent.start)
//                top.linkTo(parent.top)
            }

        )
        /*Icon(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "optionsTweet",
            tint = Color.White,
            modifier = Modifier.constrainAs(rt) {
                end.linkTo(like.start)
                top.linkTo(parent.top)
                start.linkTo(comment.end)
            }

        )
        Icon(
            painter = painterResource(id = R.drawable.ic_like),
            contentDescription = "optionsTweet",
            tint = Color.White,
            modifier = Modifier.constrainAs(like) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }

        )*/
    }
}

@Composable
fun BodyTweet(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (text, img) = createRefs()
        Text(
            text = "Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, non risus vestibulum laoreet ut ut sem. Mauris sollicitudin eros ac",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            },
            color = Color.White,
            maxLines = 5
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "img content",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .height(200.dp)
                .constrainAs(img) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

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



