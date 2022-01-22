package com.example.foodapp.view.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.R
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.EmptyState
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(val foodRepository: FoodRepository) :BaseViewModel() {
    private val _data = MutableLiveData<List<Food>>()
    val foodLiveData:LiveData<List<Food>> = _data

    val emptyStateLiveData = MutableLiveData<EmptyState>()

    init {
        getAllFood()
    }

    fun getAllFood(){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getAllFood().collect {
                if (it.isNullOrEmpty()){
                    emptyStateLiveData.postValue(EmptyState(true , R.string.favoriteEmptyStateItem ))
                }else{
                    emptyStateLiveData.postValue(EmptyState(false))

                    _data.postValue(it)

                }
            }
        }
    }

    fun deleteFood(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.deleteFood(food)
            withContext(Dispatchers.Main){
                if (foodLiveData.value.isNullOrEmpty()){
                    emptyStateLiveData.value = EmptyState(true , R.string.favoriteEmptyStateItem )
                }
            }
        }

    }
}