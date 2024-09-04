package com.example.cursoandroid.features.login.data

import com.example.cursoandroid.features.login.data.remote.LoginMockRemoteDataSource
import com.example.cursoandroid.features.login.domain.LoginRepository

class LoginDataRepository (private val remoteDataSource : LoginMockRemoteDataSource): LoginRepository {
    override fun isValid(username: String, password: String): Boolean {
        return remoteDataSource.validate(username, password)
    }

}