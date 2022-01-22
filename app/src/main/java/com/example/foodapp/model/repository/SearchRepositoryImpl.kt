package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepositoryImpl(val apiService: ApiService):SearchRepository {
    override suspend fun getSearch(name: String): Flow<List<Food>> {
       return flow {
           emit(apiService.getSearch(name))
       }
    }
}