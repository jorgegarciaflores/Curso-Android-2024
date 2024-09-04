package com.example.cursoandroid.features.login.presentation

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cursoandroid.R
import com.example.cursoandroid.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory : LoginFactory
    private lateinit var loginViewModel : LoginViewModel

    //En OnCreate se crean los eventos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }


    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)

        actionValidate.setOnClickListener{
            val username = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            if(loginViewModel.validateClicked (username, password))
            {
                (it as Button).text="Bien!!"
                Snackbar.make(findViewById(R.id.main), R.string.message_login_ok, Snackbar.LENGTH_SHORT).show()
            }
            else
            {
                (it as Button).text = "Intentalo de nuevo!!"
                Snackbar.make(findViewById(R.id.main), getString(R.string.message_login_fail), Snackbar.LENGTH_SHORT).show()
            }
            println("Pulsado boton")

        }
    }
}