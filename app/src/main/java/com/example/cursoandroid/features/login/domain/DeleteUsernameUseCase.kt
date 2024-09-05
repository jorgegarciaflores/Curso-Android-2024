package com.example.cursoandroid.features.login.domain

class DeleteUsernameUseCase (private val loginRepository: LoginRepository){
    operator fun invoke(){
        loginRepository.deleteUsername()
    }
}