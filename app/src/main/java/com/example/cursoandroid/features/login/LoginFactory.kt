package com.example.cursoandroid.features.login

import android.content.Context
import com.example.cursoandroid.features.login.data.LoginDataRepository
import com.example.cursoandroid.features.login.data.local.LoginXmlLocalDataSource
import com.example.cursoandroid.features.login.data.remote.LoginMockRemoteDataSource
import com.example.cursoandroid.features.login.domain.DeleteUsernameUseCase
import com.example.cursoandroid.features.login.domain.GetUsernameUseCase
import com.example.cursoandroid.features.login.domain.LoginRepository
import com.example.cursoandroid.features.login.domain.SaveUsernameUseCase
import com.example.cursoandroid.features.login.domain.SignInUseCase
import com.example.cursoandroid.features.login.presentation.LoginViewModel

class LoginFactory (private val context: Context){

    private val loginMockRemoteDataSource : LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginXmlLocalDataSource : LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()

    private val loginRepository : LoginRepository = provideLoginDataRepository()
    private val signInUseCase : SignInUseCase = provideSignInUseCase()
    private val saveUsernameCase : SaveUsernameUseCase = provideSaveUsernameUseCase()
    private val deleteUsernameCase : DeleteUsernameUseCase = provideDeleteUsernameUseCase()
    private val getUsernameUseCase :GetUsernameUseCase = provideGetUsernameUseCase()

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideLoginDataRepository(): LoginDataRepository  {
        return LoginDataRepository(loginMockRemoteDataSource, loginXmlLocalDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase {
        return SaveUsernameUseCase(loginRepository)
    }

    private fun provideGetUsernameUseCase(): GetUsernameUseCase {
        return GetUsernameUseCase(loginRepository)
    }

    private fun provideDeleteUsernameUseCase(): DeleteUsernameUseCase {
        return DeleteUsernameUseCase(loginRepository)
    }

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase, saveUsernameCase, deleteUsernameCase, getUsernameUseCase)
    }
}