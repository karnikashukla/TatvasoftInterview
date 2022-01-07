package com.tatvasoftinterview.common

import com.tatvasoftinterview.json.UserItemResponseData
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {

    @GET("users")
    suspend fun getUserItems(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): UserItemResponseData

    companion object {
        val serviceURL = "http://sd2-hiring.herokuapp.com/api/"
    }
}