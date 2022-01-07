package com.tatvasoftinterview.json

import com.google.gson.annotations.SerializedName

data class UserItemResponseData(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: UsersParams
)
