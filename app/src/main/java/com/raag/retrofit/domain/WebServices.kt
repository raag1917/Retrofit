package com.raag.retrofit.domain

import com.raag.retrofit.data.model.Codes
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("all")
    suspend fun getData(): List<Codes>

}