package com.example.mynewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynewcompose.ui.theme.MyNewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MySuperText("")
                }
            }
        }
    }
}

@Preview(
    name = "Patata", heightDp = 50, widthDp = 200,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 30,
    device = Devices.NEXUS_5
)
@Composable
fun MyTestSuperText(){
    MySuperText(name = "asddf")
}

@Composable
fun MySuperText(name:String) {
    Text(text = "SOOY EL $name :)")
}


