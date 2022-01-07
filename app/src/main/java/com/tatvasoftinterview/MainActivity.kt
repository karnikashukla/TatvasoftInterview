package com.tatvasoftinterview

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.tatvasoftinterview.model.UserItem

class MainActivity : AppCompatActivity() {
    private lateinit var userProfileImage: ImageView
    private lateinit var userNameTextView: MaterialTextView
    private lateinit var userItemsListRecyclerView: RecyclerView
    private var userItemList = arrayListOf<UserItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        userProfileImage = findViewById(R.id.user_profile_image)
        userNameTextView = findViewById(R.id.user_name)
        userItemsListRecyclerView = findViewById(R.id.user_items_list)
    }
}