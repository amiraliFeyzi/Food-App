package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.Food
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun getSearch(name:String):Flow<List<Food>>
}