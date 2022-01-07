package com.tatvasoftinterview.common

import retrofit2.create

class Retrofit private constructor() {
    var userItemAPI: Retrofit
        get() {
            return if (field != null)
                field
            else
                INSTANCE
        }

    companion object {
        var INSTANCE = Retrofit()
    }

    init {
        val retrofit: retrofit2.Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(Webservice.serviceURL)
            .build()
        userItemAPI = retrofit.create()
    }
}