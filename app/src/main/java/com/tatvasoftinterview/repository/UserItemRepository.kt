package com.tatvasoftinterview.repository

import com.tatvasoftinterview.common.Retrofit
import com.tatvasoftinterview.common.Webservice
import com.tatvasoftinterview.json.UserItemParams

class UserItemRepository {
    private val client: Webservice? = Retrofit.INSTANCE?.userItemAPI

    suspend fun fetchUserData(params: UserItemParams) = client?.getUserItems(params)
}