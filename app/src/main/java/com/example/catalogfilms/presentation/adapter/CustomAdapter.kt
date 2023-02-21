package com.example.catalogfilms.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogfilms.R
import com.squareup.picasso.Picasso
import com.example.catalogfilms.data.models.Result
import com.example.catalogfilms.databinding.ItemBinding


class CustomAdapter () : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var mList: List<Result> = listOf()

    fun submitList(list: List<Result>) {
        mList = list
        notifyDataSetChanged()
    }

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
    override fun onBindViewHolder(holder: ViewHolder,position: Int) { // holder это экземпляр ViewHolder
        holder.bind(mList[position]) // вызываем функцию bind (наполнение холдера), и указываем позицию
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) { // Отвечает за прорисовку, одного элемента (карточки)
        private val binding = ItemBinding.bind(view)
        fun bind(data: Result) {
            Picasso.get().load(data.multimedia.src).into(binding.itemImage)
            binding.itemName.text = data.display_title
            binding.itemRating.text = data.mpaa_rating
        }
//        val imageView: ImageView = itemView.findViewById(R.id.item_image)
//        val ratingView: TextView = itemView.findViewById(R.id.item_rating)
//        val nameView:TextView = itemView.findViewById(R.id.item_name)
//    }
    }
}