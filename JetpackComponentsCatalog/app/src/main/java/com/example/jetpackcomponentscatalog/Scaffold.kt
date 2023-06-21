package com.example.jetpackcomponentscatalog

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    Scaffold(topBar = { MyTopAppBar() }) {

    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp, navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "buscar")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }
    )

}