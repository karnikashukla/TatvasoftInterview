package com.tatvasoftinterview.common

import com.tatvasoftinterview.json.UserItemParams
import retrofit2.http.Body
import retrofit2.http.GET

interface Webservice {

    @GET("users")
    suspend fun getUserItems(@Body params: UserItemParams)

    companion object {
        val serviceURL = "http://sd2-hiring.herokuapp.com/api/"
    }
}