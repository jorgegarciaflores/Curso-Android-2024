package com.example.cursoandroid.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (context: Context?) {
    private val sharedPref = context?.getSharedPreferences("username", Context.MODE_PRIVATE)
    private val keyUsername : String = "username"

    fun saveUsername (username: String){
        with (sharedPref!!.edit()) {
            putString(keyUsername, username)
            commit()
            }
    }

    fun deleteUsername (){
        with (sharedPref!!.edit()) {
            remove(keyUsername)
            commit()
        }

        /*
        sharedPref.edit.apply{
            remove(keyUsername)
            commit()
        }
         */
    }


    fun getUsername(): String? {
            return sharedPref!!.getString(keyUsername, null)
    }
}
