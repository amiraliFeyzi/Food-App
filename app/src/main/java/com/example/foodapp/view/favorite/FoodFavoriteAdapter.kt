package com.example.foodapp.view.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemFoodFavortieBinding
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.imageloading.ImageLoading

class FoodFavoriteAdapter(val listFood:List<Food> , val imageLoading: ImageLoading):RecyclerView.Adapter<FoodFavoriteAdapter.ViewHolder>() {


    inner class ViewHolder(val binding:ItemFoodFavortieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.tvNameFoodFavorite.text = food.name
            imageLoading.load(binding.foodImageviewFavorite , food.link_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFoodFavortieBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int  = listFood.size
}