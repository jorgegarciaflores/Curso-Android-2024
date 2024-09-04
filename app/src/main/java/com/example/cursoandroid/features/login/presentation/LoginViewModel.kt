package com.example.cursoandroid.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.cursoandroid.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase) :ViewModel() {

    //Este método se llama desde la vista
    //La pulsación del botón
    fun validateClicked(username: String, password: String): Boolean{
        return signInUseCase.invoke(username, password)
    }
}