package com.example.jetpackcomposeinstagram.login.domain

import com.example.jetpackcomposeinstagram.login.data.network.LoginRepository
import javax.inject.Inject

//Aqui se encarga de la logica de negocio, por cada accion que querramos hacer se
// debe de crear un caso de uso y no ha de variar con el tiempo.
// un caso de uso puede llamar a otro caso de uso
class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    //Al poner operator e invoke nos ahorramos el tener que crear un
    //metodo para hacer la llamada. poniendo loginUseCase accederiamos al invoke
    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}