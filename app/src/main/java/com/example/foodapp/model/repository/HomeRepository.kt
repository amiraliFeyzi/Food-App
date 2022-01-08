package com.example.foodapp.model.repository

import com.example.foodapp.model.model.Food
import com.example.foodapp.model.source.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class HomeRepository (val homeRemoteDataSource: HomeRemoteDataSource) {

    suspend fun getData(categoryName:String): Flow<List<Food>> {
        return flow {
            emit(homeRemoteDataSource.getData(categoryName))
        }
    }
}