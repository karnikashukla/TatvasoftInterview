package com.tatvasoftinterview.common

import com.tatvasoftinterview.json.UserItemParams
import com.tatvasoftinterview.json.UserItemResponseData
import retrofit2.http.Body
import retrofit2.http.GET

interface Webservice {

    @GET("users")
    suspend fun getUserItems(@Body params: UserItemParams): UserItemResponseData

    companion object {
        val serviceURL = "http://sd2-hiring.herokuapp.com/api/"
    }
}