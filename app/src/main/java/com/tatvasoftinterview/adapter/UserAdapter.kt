package com.tatvasoftinterview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tatvasoftinterview.R
import com.tatvasoftinterview.model.UserItem

class UserAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = null
    var userList = arrayListOf<UserItem>()
    private var userItemsAdapter = UserItemsAdapter()
    private var userItemList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var myViewHolder: RecyclerView.ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)

        myViewHolder = UserViewHolder(view)

        return myViewHolder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder = holder as UserViewHolder
        Glide.with(context!!).load(userList[position].userImagePath).into(myViewHolder.profileImage)

        myViewHolder.userNameTextView.text = userList[position].userName

        userItemsAdapter.context = context
        if (!userList.isEmpty()) {
            for (i in userList.indices) {
                if (userList[i].userItemsArray.isNotEmpty()) {
                    for (j in userList[i].userItemsArray.indices)
                        userItemList.add(userList[i].userItemsArray[j])
                }
            }
        }
        userItemsAdapter.userItemsList = userItemList

        myViewHolder.userItemRecyclerView.adapter = userItemsAdapter
        userItemsAdapter.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profileImage: ImageView = itemView.findViewById(R.id.user_profile_image)
        var userNameTextView: TextView = itemView.findViewById(R.id.user_name)
        var userItemRecyclerView: RecyclerView = itemView.findViewById(R.id.user_items_list)
    }
}