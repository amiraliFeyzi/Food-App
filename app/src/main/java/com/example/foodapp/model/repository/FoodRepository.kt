package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

    suspend fun addFood(food: Food)

    suspend fun getAllFood(): Flow<List<Food>>

    suspend fun getData(categoryName:String): Flow<List<Food>>

    suspend fun getDetailFood(id_item:String):Flow<List<DetailFood>>

    fun deleteFood(food: Food)

}