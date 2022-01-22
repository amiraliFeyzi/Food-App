package com.example.foodapp.model.source

import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food


interface FoodDataSource {

    suspend fun addFood(food: Food)

    suspend fun getAllFood():List<Food>

    suspend fun getData(categoryName:String):List<Food>

    suspend fun getDetailFood(id_item:String):List<DetailFood>

    fun deleteFood(food: Food)
}