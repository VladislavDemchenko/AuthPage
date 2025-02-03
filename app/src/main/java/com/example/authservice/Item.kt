package com.example.authservice

import android.content.Intent
import android.media.audiofx.AudioEffect.Descriptor

class Item (val id: Int, val image: String, val title: String, val description: String, val text: String, val price: Int) {
    override fun toString(): String {
        return "Item(id='$id', image='$image', title='$title', description='$description', text='$text', price='$price')"
    }
}