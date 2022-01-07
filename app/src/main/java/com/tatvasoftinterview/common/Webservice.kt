package com.tatvasoftinterview.common

import com.tatvasoftinterview.json.UserItemResponseData
import retrofit2.http.GET

interface Webservice {

    @GET("users?offset=10&limit=10")
    suspend fun getUserItems(): UserItemResponseData

    companion object {
        val serviceURL = "http://sd2-hiring.herokuapp.com/api/"
    }
}