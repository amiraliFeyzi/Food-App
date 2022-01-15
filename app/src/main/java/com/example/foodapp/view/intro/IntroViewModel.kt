package com.example.foodapp.view.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.Slider
import com.example.foodapp.model.repository.SliderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class IntroViewModel(private val sliderRepository: SliderRepository) : BaseViewModel() {
    private val slider = MutableLiveData<List<Slider>>()
    val sliderLiveData:LiveData<List<Slider>> = slider

    init {
        getSlider()
    }

    fun getSlider(){
        viewModelScope.launch(Dispatchers.IO) {
            sliderRepository.getSlider().collect {
                slider.postValue(it)
            }
        }
    }
}