package com.example.foodapp.model.source

import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.Food

interface CartDataSource {

    suspend fun addToCart(id_item:String , name:String , price:String , link_img:String):String

    suspend fun getCartList():List<Cart>

    suspend fun deleteCart(id_item:String , name:String , price:String , link_img:String):String

}