package com.example.foodapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodapp.model.dataclass.Food

@Database(entities = [Food::class] , version = 1,exportSchema = false)
abstract class AppDatabase :RoomDatabase(){


    abstract fun FoodDao():FoodDao
}