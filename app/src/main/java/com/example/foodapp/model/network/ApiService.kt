package com.example.foodapp.model.network

import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.dataclass.Slider
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getSlider.php")
    suspend fun getSlider():List<Slider>

    @GET("getInformationHome.php")
    suspend fun getDataHome(@Query("category_name") categoryName:String):List<Food>

    @GET("getDetail.php")
    suspend fun getDetailFood(@Query("id_item")id_item:String):List<DetailFood>

    @GET("Search.php")
    suspend fun getSearch(@Query("name")nameFood:String):List<Food>

    @GET("cart.php")
    suspend fun addToCart(@Query("id_item")id_item: String , @Query("name")nameFood: String , @Query("link_img")link_img:String ,
    @Query("price")price:String):String

    @GET("getCart.php")
    suspend fun getCart():List<Cart>

    @GET("deleteCart.php")
    suspend fun deleteCart(@Query("id_item")id_item: String , @Query("name")nameFood: String , @Query("link_img")link_img:String ,
                   @Query("price" )price:String):String
}


fun createInstanceApiService():ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.69.76:8080/food_app/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    return retrofit.create(ApiService::class.java)
}