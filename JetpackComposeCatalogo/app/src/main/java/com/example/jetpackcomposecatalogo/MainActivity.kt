package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    MyRow()
                }
            }
        }
    }
}

@Composable
fun MyRow() {
//    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(text = "Text1")
//        Text(text = "Text2")
//        Text(text = "Text3")
//    }
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Text1", modifier = Modifier.width(100.dp))
        Text(text = "Text2", modifier = Modifier.width(100.dp))
        Text(text = "Text3", modifier = Modifier.width(100.dp))
        Text(text = "Text3", modifier = Modifier.width(100.dp))
        Text(text = "Text3", modifier = Modifier.width(100.dp))
        Text(text = "Text3", modifier = Modifier.width(100.dp))
    }

}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo2", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo3",
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("E")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyRow()
    }
}