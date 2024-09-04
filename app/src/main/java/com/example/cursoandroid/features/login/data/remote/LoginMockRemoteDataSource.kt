package com.example.cursoandroid.features.login.data.remote

class LoginMockRemoteDataSource {
    private val username = "android"
    private val password = "12345"

    fun validate (username : String, password: String) : Boolean {
        return (username==this.username && password==this.password)
    }
}