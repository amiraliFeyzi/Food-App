package com.example.foodapp.view.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemFoodFavortieBinding
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.imageloading.ImageLoading
import com.example.foodapp.view.common.FoodEventListener

class FoodFavoriteAdapter(val listFood:MutableList<Food> , val imageLoading: ImageLoading,val foodEventListener:FoodEventListener):RecyclerView.Adapter<FoodFavoriteAdapter.ViewHolder>() {


    inner class ViewHolder(val binding:ItemFoodFavortieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.tvNameFoodFavorite.text = food.name
            imageLoading.load(binding.foodImageviewFavorite , food.link_img)

            binding.consRoot.setOnClickListener {
                foodEventListener.onClickFood(food)
            }

            binding.consRoot.setOnLongClickListener(object : View.OnLongClickListener{
                override fun onLongClick(p0: View?): Boolean {
                    foodEventListener.onLongClickFood(food)
                    removeFood(food , adapterPosition)
                    return false
                }

            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFoodFavortieBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    fun removeFood(food: Food , position: Int){
        listFood.remove(food)
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int  = listFood.size
}