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
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension

@Composable
fun Tweet() {

    ConstraintLayout(
        Modifier.fillMaxSize()

    ) {
        val (iconProfile, headerName, headerId, headerOptions, bodyText, bodyImg, footerCommentImg,
            footerRTImg, footerLikeImg, footerCommentText, footerRTText, footerLikeText, divider) = createRefs()

        IconProfile(Modifier.constrainAs(iconProfile) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }.padding(start = 16.dp, top = 16.dp))
        HeaderTweet(iconProfile, headerName, headerId, headerOptions)
        BodyTweet(iconProfile, headerName, bodyText, bodyImg)
        FooterTweet(iconProfile, bodyImg, divider, footerCommentImg, footerRTImg, footerLikeImg,footerCommentText, footerRTText, footerLikeText)
        Divider(
            Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .constrainAs(divider) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(footerCommentImg.bottom)
                })
    }


}


@Composable
fun ConstraintLayoutScope.FooterTweet(
    startRef: ConstrainedLayoutReference,
    topRef: ConstrainedLayoutReference,
    bottomRef: ConstrainedLayoutReference,
    footerCommentImg: ConstrainedLayoutReference,
    footerRTImg: ConstrainedLayoutReference,
    footerLikeImg: ConstrainedLayoutReference,
    footerCommentText: ConstrainedLayoutReference,
    footerRTText: ConstrainedLayoutReference,
    footerLikeText: ConstrainedLayoutReference
) {


    Icon(painter = painterResource(id = R.drawable.ic_chat),
        contentDescription = "optionsTweet",
        tint = Color.White,
        modifier = Modifier.constrainAs(footerCommentImg) {
            start.linkTo(startRef.end)
            top.linkTo(topRef.bottom)
        }

    )
    Text(text = "1", color = Color.White, modifier = Modifier.constrainAs(footerCommentText){
        start.linkTo(footerCommentImg.end)
        top.linkTo(topRef.bottom)
    })
    Icon(painter = painterResource(id = R.drawable.ic_rt),
        contentDescription = "optionsTweet",
        tint = Color.White,
        modifier = Modifier.constrainAs(footerRTImg) {
            end.linkTo(footerLikeImg.start)
            start.linkTo(footerCommentImg.end)
            bottom.linkTo(bottomRef.top)
        }

    )
    Text(text = "1", color = Color.White, modifier = Modifier.constrainAs(footerRTText){
        start.linkTo(footerRTImg.end)
        top.linkTo(topRef.bottom)
    })
    Icon(painter = painterResource(id = R.drawable.ic_like),
        contentDescription = "optionsTweet",
        tint = Color.White,
        modifier = Modifier.constrainAs(footerLikeImg) {
            end.linkTo(footerLikeText.start)
            top.linkTo(topRef.bottom)
        }

    )
    Text(text = "1", color = Color.White, modifier = Modifier.constrainAs(footerLikeText){
        end.linkTo(parent.end)
        top.linkTo(topRef.bottom)
    })

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
        modifier = Modifier.constrainAs(bodyText) {
            top.linkTo(topRef.bottom)
            start.linkTo(startRef.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        },
        color = Color.White,
        maxLines = 5
    )
    Image(painter = painterResource(id = R.drawable.profile),
        contentDescription = "img content",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
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

    Text("Xevi", color = Color.White, modifier = Modifier.constrainAs(headerName) {
        top.linkTo(parent.top)
        start.linkTo(startRef.end)
    })
    Text("@XeviDev 4h", color = Color(0xFF656A74), modifier = Modifier.constrainAs(headerId) {
        top.linkTo(parent.top)
        start.linkTo(headerName.end)
    })

    Icon(painter = painterResource(id = R.drawable.ic_dots),
        contentDescription = "optionsTweet",
        tint = Color.White,
        modifier = Modifier.constrainAs(headerOptions) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }

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



