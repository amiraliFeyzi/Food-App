package com.example.foodapp.model.database

import androidx.room.*
import com.example.foodapp.model.dataclass.Food

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFood(food: Food)

    @Query("SELECT * FROM foodFavorite")
    fun getAllFood():List<Food>

    @Delete
    fun deleteFood(food: Food)



}