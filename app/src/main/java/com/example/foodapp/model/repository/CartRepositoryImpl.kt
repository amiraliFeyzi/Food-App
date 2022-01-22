package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.source.CartDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CartRepositoryImpl(val cartRemoteDataSource: CartDataSource) :CartRepository{
    override suspend fun addToCart(
        id_item: String,
        name: String,
        price: String,
        link_img: String
    ): Flow<String> {
        return flow {
            emit(cartRemoteDataSource.addToCart(id_item , name ,price ,link_img))
        }
    }

    override suspend fun getCartList(): Flow<List<Cart>> {
        return flow {
            emit(cartRemoteDataSource.getCartList())
        }
    }

    override suspend fun deleteCart(
        id_item: String,
        name: String,
        price: String,
        link_img: String
    ):String {
       return cartRemoteDataSource.deleteCart(id_item, name, price, link_img)

    }

}