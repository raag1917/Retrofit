package com.raag.retrofit.ui.viewmodel

import android.util.Log.d
import androidx.lifecycle.*
import com.raag.retrofit.domain.Repo
import com.raag.retrofit.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class MainViewModel(private val repo: Repo) : ViewModel() {


    val fetchCodesList = liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getCodes())
            } catch (exception: Exception) {
                d("Context", "$exception")
            }
    }


}