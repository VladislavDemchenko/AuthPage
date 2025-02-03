package com.example.authservice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {

    lateinit var loginField: EditText
    lateinit var passwordField: EditText
    lateinit var button: Button
    lateinit var registerLink: TextView
    lateinit var db: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initializing()
        Log.d("AuthActivity", "onCreate")

        button.setOnClickListener{
            val login = loginField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            if (login.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                if(db.authUser(login, password)){
                    Toast.makeText(this, "User is found", Toast.LENGTH_SHORT).show()
                    loginField.text.clear()
                    passwordField.text.clear()
                } else {
                    Toast.makeText(this, "User is not found", Toast.LENGTH_SHORT).show()
                }
            }
        }


        registerLink.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

     fun initializing() {
        loginField = findViewById(R.id.login_auth)
        passwordField = findViewById(R.id.password_auth)
        button = findViewById(R.id.button_auth)
        registerLink = findViewById(R.id.registration_link)
        db = DbHelper(this, null)
    }
}