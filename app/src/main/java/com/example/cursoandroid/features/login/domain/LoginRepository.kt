package com.example.cursoandroid.features.login.domain

interface LoginRepository {
    fun isValid (username: String, password: String) : Boolean
}