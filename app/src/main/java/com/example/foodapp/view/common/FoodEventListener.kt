package com.example.foodapp.view.common

import com.example.foodapp.model.dataclass.Food

interface FoodEventListener {
    fun onClickFood(food: Food)

    fun onLongClickFood(food: Food)
}