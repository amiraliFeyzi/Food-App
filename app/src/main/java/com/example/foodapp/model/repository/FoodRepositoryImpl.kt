package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.source.FoodDataSource
import com.example.foodapp.model.source.FoodLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FoodRepositoryImpl (val foodRemoteDataSource: FoodDataSource , val foodLocalDataSource: FoodDataSource ):FoodRepository {
    override suspend fun addFood(food: Food) {
        foodLocalDataSource.addFood(food)
    }

    override suspend fun getAllFood(): Flow<List<Food>> {
        return flow {
            emit(foodLocalDataSource.getAllFood())
        }
    }

    override suspend fun getData(categoryName:String): Flow<List<Food>> {
        return flow {
            emit(foodRemoteDataSource.getData(categoryName))
        }
    }


    override suspend fun getDetailFood(id_item:String):Flow<List<DetailFood>>{
        return flow {
            emit(foodRemoteDataSource.getDetailFood(id_item))
        }
    }

    override  fun deleteFood(food: Food)  = foodLocalDataSource.deleteFood(food)


}