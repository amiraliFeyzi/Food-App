package com.example.foodapp.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.foodapp.model.dataclass.Food

@Dao
interface FoodDao {
    @Insert
    fun addFood(food: Food)

    @Query("SELECT * FROM foodFavorite")
    fun getAllFood():List<Food>
}