package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.Food
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun addToCart(id_item:String , name:String , price:String , link_img:String):Flow<String>

    suspend fun getCartList(): Flow<List<Cart>>

    suspend fun deleteCart(id_item:String , name:String , price:String , link_img:String):String


}