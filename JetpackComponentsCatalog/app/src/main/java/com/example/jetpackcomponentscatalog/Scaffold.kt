package com.example.jetpackcomponentscatalog

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar() {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }
        },
        scaffoldState = scaffoldState,
        bottomBar = {MyBottomNavigation()},
        floatingActionButton = {MyFAB()},
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = true
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp, navigationIcon = {
            IconButton(onClick = { onClickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "buscar")
            }
            IconButton(onClick = { onClickIcon("Peligro") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "Dangerous")
            }
        }
    )

}

@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "home"
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "fav"
            )
        }, label = { Text(text = "Fav") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "person"
            )
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFAB(){
    FloatingActionButton(onClick = {}, backgroundColor = Color.Yellow, contentColor = Color.Black) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}