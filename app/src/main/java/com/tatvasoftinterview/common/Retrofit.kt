package com.tatvasoftinterview.common

import retrofit2.create

class Retrofit private constructor() {
    var userItemAPI: Webservice

    companion object {
        var INSTANCE: Retrofit? = null
            get() {
                if (field == null)
                    field = Retrofit()
                return field
            }
    }

    init {
        val retrofit: retrofit2.Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(Webservice.serviceURL)
            .build()
        userItemAPI = retrofit.create()
    }
}