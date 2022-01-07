package com.tatvasoftinterview.model

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("name")
    val userName: String,
    @SerializedName("image")
    val userImagePath: String,
    @SerializedName("items")
    val userItemsArray: List<String> = arrayListOf()
)
