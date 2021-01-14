package com.raag.retrofit.ui

/*
* Diseño y desarrollo:
* Ramiro Abad Gómez
* Android Developer
* */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.raag.retrofit.adapter.Adapter
import com.raag.retrofit.data.Codes
import com.raag.retrofit.databinding.ActivityMainBinding
import com.raag.retrofit.interfaces.CodesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity: AppCompatActivity() {

    companion object{
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }

    lateinit var adapter: Adapter
    lateinit var linearLayout: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        linearLayout = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayout

        getData()

    }

    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CodesAPI::class.java)

        val retrofit = retrofitBuilder.getData()

        retrofit.enqueue(object : Callback<List<Codes>> {

            override fun onResponse(call: Call<List<Codes>>, response: Response<List<Codes>>) {
                val list = response.body()!!
                adapter = Adapter(this@MainActivity, list)
                adapter.notifyDataSetChanged()
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<Codes>>, t: Throwable) {
                d("Message Error", "Error cargando datos" + t.message)
            }
        })
    }

}