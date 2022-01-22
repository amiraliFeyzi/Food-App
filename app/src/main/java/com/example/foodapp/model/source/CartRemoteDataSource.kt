package com.example.foodapp.model.source

import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.network.ApiService

class CartRemoteDataSource(val apiService: ApiService) :CartDataSource {
    override suspend fun addToCart(id_item: String, name: String, price: String, link_img: String): String  = apiService.addToCart(id_item , name , link_img , price)

    override suspend fun getCartList(): List<Cart>  = apiService.getCart()
    override suspend fun deleteCart(
        id_item: String,
        name: String,
        price: String,
        link_img: String
    ):String {
        return apiService.deleteCart(id_item, name, link_img, price)
    }
}