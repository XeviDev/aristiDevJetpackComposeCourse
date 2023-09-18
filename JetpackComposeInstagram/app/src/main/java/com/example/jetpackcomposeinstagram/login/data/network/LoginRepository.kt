package com.example.jetpackcomposeinstagram.login.data.network

import javax.inject.Inject

//Se encarga de gestionar si la llamada es a una bd, bd interna, un archivo, etc
class LoginRepository @Inject constructor(private val api:LoginService){

    suspend fun doLogin(user: String, password: String):Boolean {
        return api.doLogin(user, password)
    }
}