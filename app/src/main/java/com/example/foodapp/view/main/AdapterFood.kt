package com.example.foodapp.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemHomeBinding
import com.example.foodapp.model.imageloading.ImageLoading
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.view.common.FoodEventListener

class AdapterFood(val data:List<Food>, val imageLoading: ImageLoading  , val foodEventListener: FoodEventListener):RecyclerView.Adapter<AdapterFood.ViewHolder>() {

    inner class ViewHolder(val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.nameFood.text = food.name
            binding.descriptionFood.text = food.description
            binding.priceFood.text = "$ ${food.price}"
            imageLoading.load(binding.ivBurger , food.link_img)

            binding.consroot.setOnClickListener {
                foodEventListener.onClickFood(food)
            }
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