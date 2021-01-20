package com.raag.retrofit.domain

import com.raag.retrofit.data.model.Codes
import com.raag.retrofit.vo.Resource

interface Repo {

    suspend fun getCodes(): Resource<List<Codes>>
}