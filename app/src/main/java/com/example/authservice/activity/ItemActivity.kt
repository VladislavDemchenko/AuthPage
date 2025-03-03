package com.example.authservice.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.authservice.R
import com.razorpay.Checkout

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_live_XXXXXXXXXXXXXX")

        val title: TextView = findViewById(R.id.item_title_one)
        val text: TextView = findViewById(R.id.item_text_one)

		title.text = intent.getStringExtra("itemTitle")
		text.text = intent.getStringExtra("itemText")
    }
}