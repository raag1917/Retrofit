package com.raag.retrofit.vo


import com.google.gson.GsonBuilder
import com.raag.retrofit.domain.WebServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebServices::class.java)
    }
}