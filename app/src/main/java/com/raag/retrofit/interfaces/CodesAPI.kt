package com.raag.retrofit.interfaces

import com.raag.retrofit.data.Codes
import retrofit2.Call
import retrofit2.http.GET

interface CodesAPI {

    @GET("all")
    fun getData(): Call<List<Codes>>

}