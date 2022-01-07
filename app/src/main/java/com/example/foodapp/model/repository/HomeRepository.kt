package com.example.foodapp.model.repository

import com.example.foodapp.model.model.Burger
import com.example.foodapp.model.source.HomeRemoteDataSource
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class HomeRepository (val homeRemoteDataSource: HomeRemoteDataSource) {

    suspend fun getData(categoryName:String):kotlinx.coroutines.flow.Flow<List<Burger>>{
        return flow {
            val list = homeRemoteDataSource.getData(categoryName)
            emit(list)
        }
    }
}