package com.example.authservice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "image1", "Title1", "Description1", "Text1", 100))
        items.add(Item(2, "image2", "Title2", "Description2", "Text2", 200))
        items.add(Item(3, "image3", "Title3", "Description3", "Text3", 300))
    }
}