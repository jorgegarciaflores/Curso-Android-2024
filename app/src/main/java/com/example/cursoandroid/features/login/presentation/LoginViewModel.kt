package com.example.cursoandroid.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.cursoandroid.features.login.domain.DeleteUsernameUseCase
import com.example.cursoandroid.features.login.domain.GetUsernameUseCase
import com.example.cursoandroid.features.login.domain.SaveUsernameUseCase
import com.example.cursoandroid.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase,
                     private val saveUsernameUseCase: SaveUsernameUseCase,
                     private val deleteUsernameUseCase: DeleteUsernameUseCase,
                     private val getUsernameUseCase: GetUsernameUseCase) : ViewModel() {

    //Este método se llama desde la vista
    //La pulsación del botón
    fun validateClicked(username: String, password: String, isRememberChecked:Boolean): Boolean{
        if(isRememberChecked)
            saveUsernameUseCase.invoke(username)
        else
            deleteUsernameUseCase.invoke()
        return signInUseCase.invoke(username, password)
    }

    fun onResume(): String? {
        return getUsernameUseCase.invoke()
        //return getUsernameUseCase.invoke()
        /*
        val username : String = getUsernameUseCase.invoke()
        // Como tratar los nulos: ?
        username?.let {
            it //it = username no nulo
        }
        Otra:
        val username : String? = getUsernameUseCase.invoke()
        return username

        */
    }
}