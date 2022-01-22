package com.example.foodapp.model.source

import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.network.ApiService

class FoodRemoteDataSource(val apiService: ApiService):FoodDataSource {
    override suspend fun addFood(food: Food) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFood(): List<Food> {
        TODO("Not yet implemented")
    }

    override suspend fun getData(categoryName:String):List<Food> = apiService.getDataHome(categoryName)

    override suspend fun getDetailFood(id_item:String):List<DetailFood> = apiService.getDetailFood(id_item)
    override  fun deleteFood(food: Food) {
        TODO("Not yet implemented")
    }

}