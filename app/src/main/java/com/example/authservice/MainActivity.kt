package com.example.authservice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var loginField: EditText
    lateinit var emailField: EditText
    lateinit var passwordField: EditText
    lateinit var buttonField: Button
    lateinit var db: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializing()

        buttonField.setOnClickListener{
            val login = loginField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            if (login.isEmpty() && email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                db.insertUser(User(login, email, password))
                loginField.text.clear()
                emailField.text.clear()
                passwordField.text.clear()
                Toast.makeText(this, "User created", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializing() {
        loginField = findViewById(R.id.login)
        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.password)
        buttonField = findViewById(R.id.button)
        db = DbHelper(this, null)
    }
}