package com.example.foodapp.model.repository

import com.example.foodapp.model.model.Burger
import com.example.foodapp.model.source.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class HomeRepository (val homeRemoteDataSource: HomeRemoteDataSource) {

    suspend fun getData(categoryName:String): Flow<List<Burger>> {
        return flow {
            val list = homeRemoteDataSource.getData(categoryName)
            emit(list)
        }
    }
}