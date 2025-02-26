package com.example.authservice.entity

class User (val login: String, val email: String, val password: String) {

    override fun toString(): String {
        return "User(login='$login', email='$email', password='$password')"
    }
}