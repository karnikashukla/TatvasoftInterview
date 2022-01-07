package com.tatvasoftinterview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tatvasoftinterview.R

class UserItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = null
    var userItemsList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder
        val myView =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)

        viewHolder = MyViewHolder(myView)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myHolder = holder as MyViewHolder
        if (context != null) {
            Glide.with(context!!).load(userItemsList[position]).into(myHolder.itemImageView)
        }
    }

    override fun getItemCount(): Int {
        return userItemsList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImageView: ImageView = itemView.findViewById(R.id.user_item_image)
    }
}