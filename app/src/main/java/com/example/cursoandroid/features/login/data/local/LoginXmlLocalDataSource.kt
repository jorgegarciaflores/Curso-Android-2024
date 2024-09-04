package com.example.cursoandroid.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private  val context: Context?) {
    private val sharedPref = context?.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    fun saveUsername (username: String){
        with (sharedPref!!.edit()) {
            putString("username", username)
            commit()
            }
    }
}