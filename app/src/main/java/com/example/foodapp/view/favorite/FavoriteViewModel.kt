package com.example.foodapp.view.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FavoriteViewModel(val foodRepository: FoodRepository) :BaseViewModel() {
    private val _data = MutableLiveData<List<Food>>()
    val foodLiveData:LiveData<List<Food>> = _data

    init {
        getAllFood()
    }

    fun getAllFood(){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getAllFood().collect {
                _data.postValue(it)
            }
        }
    }
}