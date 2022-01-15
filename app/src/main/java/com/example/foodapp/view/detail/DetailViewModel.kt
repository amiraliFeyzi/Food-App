package com.example.foodapp.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel(val foodRepository: FoodRepository):BaseViewModel() {
    private val _data = MutableLiveData<List<DetailFood>>()
    val detailFoodLiveData:LiveData<List<DetailFood>> = _data


    fun getData(id_item:String){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getDetailFood(id_item)
                .collect {
                    _data.postValue(it)
                }
        }

    }

    fun addFoodToDb(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.addFood(food)
        }
    }
}