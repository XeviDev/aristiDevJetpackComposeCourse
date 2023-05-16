package com.example.jetpackcomponentscatalog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(show: Boolean, onDissmiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDissmiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Soy una Patata :)") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDissmiss() }) {
                    Text(text = "dismissButton")
                }
            })
    }
}