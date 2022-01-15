package com.example.foodapp.model.repository

import com.example.foodapp.model.dataclass.Slider
import com.example.foodapp.model.repository.source.SliderRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SliderRepository ( val sliderRemoteDataSource: SliderRemoteDataSource) {

    suspend fun getSlider():Flow<List<Slider>>{
        return flow {
            emit(sliderRemoteDataSource.getSlider())

        }

    }
}