package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

@Composable
fun BasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    var completedValue by remember {
        mutableStateOf("0.0")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completedValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = completedValue)
    }
}
