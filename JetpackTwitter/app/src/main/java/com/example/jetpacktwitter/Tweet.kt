package com.example.jetpacktwitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension


val colorTw: Color = Color(0xFF656A74)

@Composable
fun Tweet() {

    ConstraintLayout(
        Modifier.fillMaxSize()

    ) {
        val (iconProfile, headerName, headerId, headerOptions, bodyText, bodyImg, footerCommentIB,
            footerRTIB, footerLikeIB, divider) = createRefs()

        IconProfile(
            Modifier
                .constrainAs(iconProfile) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(start = 16.dp, top = 16.dp, end = 16.dp))
        HeaderTweet(iconProfile, headerName, headerId, headerOptions)
        BodyTweet(iconProfile, headerName, bodyText, bodyImg)
        FooterTweet(
            iconProfile,
            bodyImg,
            footerCommentIB,
            footerRTIB,
            footerLikeIB
        )
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(color = colorTw)
                .constrainAs(divider) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(footerCommentIB.bottom)
                })
    }


}


@Composable
fun ConstraintLayoutScope.FooterTweet(
    startRef: ConstrainedLayoutReference,
    topRef: ConstrainedLayoutReference,
    footerCommentIB: ConstrainedLayoutReference,
    footerRTIB: ConstrainedLayoutReference,
    footerLikeIB: ConstrainedLayoutReference
) {

    var commentControl by rememberSaveable {
        mutableStateOf(false)
    }
    var commentTextControl by rememberSaveable {
        mutableStateOf(1)
    }
    IconButton(onClick = {
        commentControl = !commentControl
        if (commentControl) {
            commentTextControl += 1
        } else {
            commentTextControl -= 1
        }
    }, modifier = Modifier

        .constrainAs(footerCommentIB) {
            start.linkTo(startRef.end)
            top.linkTo(topRef.bottom)
        }
        .padding(start = 32.dp, end = 4.dp)) {
        Row() {
            Icon(
                painter = if (commentControl) {
                    painterResource(id = R.drawable.ic_chat_filled)
                } else {
                    painterResource(id = R.drawable.ic_chat)
                },
                contentDescription = "optionsTweet",
                tint = colorTw
            )
            Text(
                text = commentTextControl.toString(),
                color = colorTw,
                modifier = Modifier.padding(start = 8.dp)
            )
        }


    }

    var rtControl by rememberSaveable {
        mutableStateOf(false)
    }
    var rtTextControl by rememberSaveable {
        mutableStateOf(1)
    }
    IconButton(onClick = {
        rtControl = !rtControl
        if (rtControl) {
            rtTextControl += 1
        } else {
            rtTextControl -= 1
        }
    }, modifier = Modifier

        .constrainAs(footerRTIB) {
            start.linkTo(footerCommentIB.end)
            end.linkTo(footerLikeIB.start)
            top.linkTo(topRef.bottom)
        }
        .padding()) {
        Row() {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "optionsTweet",
                tint = if (rtControl) {
                    Color.Green
                } else {
                    colorTw
                },
                modifier = Modifier
                    .size(28.dp)
            )
            Text(
                text =
                rtTextControl.toString(),
                fontSize = 17.sp,
                color = colorTw,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

    var likeControl by rememberSaveable {
        mutableStateOf(false)
    }
    var likeTextControl by rememberSaveable {
        mutableStateOf(1)
    }
    IconButton(onClick = {
        likeControl = !likeControl
        if (likeControl) {
            likeTextControl += 1
        } else {
            likeTextControl -= 1
        }
    }, modifier = Modifier

        .constrainAs(footerLikeIB) {
            end.linkTo(parent.end)
            top.linkTo(topRef.bottom)
        }
        .padding(end = 32.dp)) {
        Row() {
            Icon(
                painter = if (likeControl) {
                    painterResource(id = R.drawable.ic_like_filled)
                } else {
                    painterResource(id = R.drawable.ic_like)
                },
                contentDescription = "optionsTweet",
                tint = if (likeControl) {
                    Color.Red
                } else {
                    colorTw
                }
            )
            Text(
                text = likeTextControl.toString(),
                color = colorTw,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }

}

@Composable
fun ConstraintLayoutScope.BodyTweet(
    startRef: ConstrainedLayoutReference,
    topRef: ConstrainedLayoutReference,
    bodyText: ConstrainedLayoutReference,
    bodyImg: ConstrainedLayoutReference
) {

    Text(
        text = "Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, Lorem ipsum dolor sit amet, non risus vestibulum laoreet ut ut sem. Mauris sollicitudin eros ac",
        modifier = Modifier
            .constrainAs(bodyText) {
                top.linkTo(topRef.bottom)
                start.linkTo(startRef.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            .padding(end = 16.dp, top = 16.dp),
        color = Color.White,
        maxLines = 5
    )
    //El orden de los modificadores altera el resultado. Primero el padding.
    Image(painter = painterResource(id = R.drawable.profile),
        contentDescription = "img content",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(200.dp)
            .constrainAs(bodyImg) {
                top.linkTo(bodyText.bottom)
                start.linkTo(startRef.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })

}

@Composable
fun ConstraintLayoutScope.HeaderTweet(
    startRef: ConstrainedLayoutReference,
    headerName: ConstrainedLayoutReference,
    headerId: ConstrainedLayoutReference,
    headerOptions: ConstrainedLayoutReference
) {

    Text("Xevi", color = Color.White, modifier = Modifier
        .padding(end = 8.dp)
        .constrainAs(headerName) {
            top.linkTo(parent.top)
            start.linkTo(startRef.end)
        }
        .padding(top = 16.dp))
    Text("@XeviDev 4h", color = colorTw, modifier = Modifier
        .constrainAs(headerId) {
            top.linkTo(parent.top)
            start.linkTo(headerName.end)
        }
        .padding(top = 16.dp))

    Icon(
        painter = painterResource(id = R.drawable.ic_dots),
        contentDescription = "optionsTweet",
        tint = Color.White,
        modifier = Modifier
            .constrainAs(headerOptions) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }
            .padding(end = 16.dp, top = 16.dp)

    )


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





