package com.example.jetpackcomponentscatalog.model

sealed class Routes(val route:String) {
    //Objetos en la sealed class empiezan en mayúsculas
    object Pantalla1:Routes("pantalla1")
    object Pantalla2:Routes("pantalla2")
    object Pantalla3:Routes("pantalla3")
    object Pantalla4:Routes("pantalla4/{age}"){
        fun createRoute(age:Int) = "pantalla4/$age"
    }
    object Pantalla5:Routes("pantalla5?name={name}"){
        fun createRoute(name:String) = "pantalla5?name=$name"
    }


}