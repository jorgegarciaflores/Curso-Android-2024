package com.example.cursoandroid.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.cursoandroid.features.login.domain.SaveUsernameUseCase
import com.example.cursoandroid.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase,
                     private val saveUsernameUseCase: SaveUsernameUseCase) : ViewModel() {

    //Este método se llama desde la vista
    //La pulsación del botón
    fun validateClicked(username: String, password: String, isRememberChecked:Boolean): Boolean{
        if(isRememberChecked)
            saveUsernameUseCase.invoke(username)
        return signInUseCase.invoke(username, password)
    }
}