package com.raag.retrofit.ui

/*
* Diseño y desarrollo:
* Ramiro Abad Gómez
* Android Developer
* */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import com.raag.retrofit.vo.Resource
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.raag.retrofit.adapter.Adapter
import com.raag.retrofit.data.model.DataSource
import com.raag.retrofit.databinding.ActivityMainBinding
import com.raag.retrofit.domain.RepoImpl
import com.raag.retrofit.ui.viewmodel.MainViewModel
import com.raag.retrofit.ui.viewmodel.VMFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupAdapter()


    }

    private fun setupAdapter() {
        viewModel.fetchCodesList.observe(this@MainActivity, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.loading.visibility = View.GONE
                    binding.recyclerView.adapter = Adapter(this, result.data)
                }
                is Resource.Failure -> {
                    binding.loading.visibility = View.GONE
                    Toast.makeText(
                        this@MainActivity,
                        "Error al cargar datos: ${result.exception}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }

    private fun setupViewModel() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}