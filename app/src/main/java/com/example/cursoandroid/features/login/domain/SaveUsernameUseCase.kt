package com.example.cursoandroid.features.login.domain

class SaveUsernameUseCase (private val loginRepository: LoginRepository){

    operator fun invoke(username: String){
        loginRepository.saveUsername(username)
    }
}