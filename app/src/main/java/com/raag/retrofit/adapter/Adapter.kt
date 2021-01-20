package com.raag.retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raag.retrofit.data.model.Codes
import com.raag.retrofit.R
import com.raag.retrofit.databinding.RowBinding

class Adapter(private val context: Context, private var list: List<Codes>) :
    RecyclerView.Adapter<Adapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)

        fun bind(item: Codes) = with(binding) {
            binding.tvCountry.text = item.name
            binding.tvCode.text = item.numericCode
            binding.tvZona.text = item.population.toString()
        }
    }
}