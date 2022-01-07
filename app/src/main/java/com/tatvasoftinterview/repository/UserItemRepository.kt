package com.tatvasoftinterview.repository

import com.tatvasoftinterview.common.Retrofit
import com.tatvasoftinterview.common.Webservice

class UserItemRepository {
    private val client: Webservice? = Retrofit.INSTANCE?.userItemAPI

    suspend fun fetchUserData() = client?.getUserItems()
}