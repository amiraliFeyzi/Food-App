package com.example.foodapp.model.source

import com.example.foodapp.model.model.Food
import com.example.foodapp.model.network.ApiService

class HomeRemoteDataSource(val apiService: ApiService) {

    suspend fun getData(categoryName:String):List<Food> = apiService.getDataHome(categoryName)
}