package com.example.jetpackcomposeinstagram.login.data.network

import com.example.jetpackcomposeinstagram.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
//Se encarga de tener los endpoints de la API
interface LoginClient {
    @GET("/v3/f78c9d33-28b1-4f81-9cf1-6d6ff78fa014")
    suspend fun doLogin():Response<LoginResponse>
}