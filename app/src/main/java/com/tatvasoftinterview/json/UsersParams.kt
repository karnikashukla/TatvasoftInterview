package com.tatvasoftinterview.json

import com.google.gson.annotations.SerializedName
import com.tatvasoftinterview.model.UserItem

data class UsersParams(
    @SerializedName("users")
    val userItemParams: List<UserItem>
)
