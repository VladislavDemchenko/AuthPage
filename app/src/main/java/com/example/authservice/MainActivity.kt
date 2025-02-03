package com.example.authservice

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    lateinit var auth_link: TextView
    lateinit var authIntent: Intent

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
                if(db.isAuth(login)){
                    Toast.makeText(this, "User with this login already exist", Toast.LENGTH_SHORT).show()
                } else {
                    db.insertUser(User(login, email, password))
                    loginField.text.clear()
                    emailField.text.clear()
                    passwordField.text.clear()
                    startActivity(authIntent)
                }
            }
        }

        auth_link.setOnClickListener(){
            startActivity(authIntent)
        }
    }

     fun initializing() {
        loginField = findViewById(R.id.login)
        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.password)
        buttonField = findViewById(R.id.button)
        auth_link = findViewById(R.id.auth_link)
        db = DbHelper(this, null)
         authIntent = Intent(this, AuthActivity::class.java)
    }
}