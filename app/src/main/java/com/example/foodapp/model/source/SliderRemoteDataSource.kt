package com.example.foodapp.model.source

import com.example.foodapp.model.model.Slider
import com.example.foodapp.model.network.ApiService

class SliderRemoteDataSource (val apiService: ApiService) {

    suspend fun getSlider():List<Slider>{
        return apiService.getSlider()
    }
}