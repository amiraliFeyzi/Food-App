package com.example.foodapp.model.network

import com.example.foodapp.model.model.Burger
import com.example.foodapp.model.model.Slider
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getSlider.php")
    suspend fun getSlider():List<Slider>

    @GET("getInformationHome.php")
    suspend fun getDataHome(@Query("category_name") categoryName:String):List<Burger>
}


fun createInstanceApiService():ApiService{
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.69.76:8080/food_app/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    return retrofit.create(ApiService::class.java)
}