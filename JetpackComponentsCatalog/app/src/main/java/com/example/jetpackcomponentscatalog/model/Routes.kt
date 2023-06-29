package com.example.jetpackcomponentscatalog.model

sealed class Routes(val route:String) {
    //Objetos en la sealed class empiezan en mayúsculas
    object Pantalla1:Routes("pantalla1")
    object Pantalla2:Routes("pantalla2")
    object Pantalla3:Routes("pantalla3")
}