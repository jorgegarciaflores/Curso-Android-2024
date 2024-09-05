package com.example.cursoandroid.features.login.data

import com.example.cursoandroid.features.login.data.local.LoginXmlLocalDataSource
import com.example.cursoandroid.features.login.data.remote.LoginMockRemoteDataSource
import com.example.cursoandroid.features.login.domain.LoginRepository

class LoginDataRepository (private val remoteDataSource : LoginMockRemoteDataSource,
                           private val localDataSource : LoginXmlLocalDataSource,
    ): LoginRepository {
    override fun isValid(username: String, password: String): Boolean {
        return remoteDataSource.validate(username, password)
    }

    override fun saveUsername(username: String) {
        localDataSource.saveUsername((username))
    }

    override fun deleteUsername() {
        localDataSource.deleteUsername()
    }
}