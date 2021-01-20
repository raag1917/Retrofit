package com.raag.retrofit.data.model


import com.raag.retrofit.vo.Resource
import com.raag.retrofit.vo.RetrofitClient

class DataSource {
    suspend fun getCodeByName (): Resource<List<Codes>>{
        return Resource.Success(RetrofitClient.webservice.getData())
    }
}