package com.example.authservice

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.authservice.activity.ItemActivity
import com.example.authservice.entity.Item

class ItemsAdapter(private var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var image: ImageView = view.findViewById(R.id.item_image)
        var title: TextView = view.findViewById(R.id.item_title)
        var description: TextView = view.findViewById(R.id.item_description)
        var price: TextView = view.findViewById(R.id.item_price)
        var button: Button = view.findViewById(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(context.resources.getIdentifier(items[position].image, "drawable", context.packageName))
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        holder.price.text = items[position].price.toString()

        holder.button.setOnClickListener(){
            val intent = Intent(context, ItemActivity::class.java)

            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)

            context.startActivity(intent)
        }
    }
}