package com.example.authservice.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.authservice.ItemsAdapter
import com.example.authservice.entity.Item
import com.example.authservice.R

class ItemListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val itemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "breathtaking_fantasy", "Title1", "Description1", "Text1", 100))
        items.add(Item(2, "dark_fant", "Title2", "Description2", "Text2", 200))
        items.add(Item(3, "unsplash", "Title3", "Description3", "Text3", 300))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}