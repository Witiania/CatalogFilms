package com.example.catalogfilms.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogfilms.MainData
import com.example.catalogfilms.R

class CustomAdapter (private val mList: List<MainData>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(item.image)

        // sets the text to the textview from our itemHolder class
        holder.ageView.text = item.age

        holder.nameView.text = item.name



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val ageView: TextView = itemView.findViewById(R.id.item_age)
        val nameView:TextView = itemView.findViewById(R.id.item_name)
    }
}
