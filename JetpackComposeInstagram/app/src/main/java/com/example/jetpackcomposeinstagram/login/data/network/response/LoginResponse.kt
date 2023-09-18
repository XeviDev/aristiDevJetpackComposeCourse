package com.example.jetpackcomposeinstagram.login.data.network.response

import com.google.gson.annotations.SerializedName
//La respuesta de la API.
data class LoginResponse(@SerializedName("success") val success: Boolean)