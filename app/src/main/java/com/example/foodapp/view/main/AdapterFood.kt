package com.example.foodapp.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemHomeBinding
import com.example.foodapp.model.imageloading.ImageLoading
import com.example.foodapp.model.model.Burger

class AdapterFood(val data:List<Burger> , val imageLoading: ImageLoading):RecyclerView.Adapter<AdapterFood.ViewHolder>() {

    inner class ViewHolder(val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(burger: Burger){
            binding.nameFood.text = burger.name
            binding.descriptionFood.text = burger.description
            binding.priceFood.text = "$ ${burger.price}"
            imageLoading.load(binding.ivBurger , burger.link_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}