package com.example.cursoandroid.features.login

import com.example.cursoandroid.features.login.data.LoginDataRepository
import com.example.cursoandroid.features.login.data.remote.LoginMockRemoteDataSource
import com.example.cursoandroid.features.login.domain.LoginRepository
import com.example.cursoandroid.features.login.domain.SignInUseCase
import com.example.cursoandroid.features.login.presentation.LoginViewModel

class LoginFactory {

    private val loginMockRemoteDataSource : LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginRepository : LoginRepository = provideLoginDataRepository()
    private val signInUseCase : SignInUseCase = provideSignInUseCase()

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository  {
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }
}