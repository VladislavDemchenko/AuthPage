package com.example.authservice.entity

class Item (val id: Int, val image: String, val title: String, val description: String, val text: String, val price: Int) {
    override fun toString(): String {
        return "Item(id='$id', image='$image', title='$title', description='$description', text='$text', price='$price')"
    }
}