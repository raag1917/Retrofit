package com.raag.retrofit.domain

import com.raag.retrofit.data.model.Codes
import com.raag.retrofit.data.model.DataSource
import com.raag.retrofit.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getCodes(): Resource<List<Codes>> {
        return dataSource.getCodeByName()
    }

}