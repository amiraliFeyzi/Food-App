package com.example.foodapp.model.source

import com.example.foodapp.model.database.FoodDao
import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food

class FoodLocalDataSource(val foodDao: FoodDao):FoodDataSource {

    override suspend fun addFood(food: Food) = foodDao.addFood(food)

    override suspend fun getAllFood():List<Food> = foodDao.getAllFood()

    override suspend fun getData(categoryName: String): List<Food> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailFood(id_item: String): List<DetailFood> {
        TODO("Not yet implemented")
    }

    override  fun deleteFood(food: Food)  = foodDao.deleteFood(food)
}