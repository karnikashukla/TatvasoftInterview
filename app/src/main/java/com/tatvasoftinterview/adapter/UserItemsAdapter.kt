package com.tatvasoftinterview.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.tatvasoftinterview.R
import com.tatvasoftinterview.model.UserItem

class UserItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = null
    var userItemsList = arrayListOf<UserItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return userItemsList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImageView: ImageView = itemView.findViewById(R.id.user_item_image)
    }
}