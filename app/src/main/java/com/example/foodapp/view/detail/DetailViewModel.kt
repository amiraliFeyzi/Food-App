package com.example.foodapp.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.DetailFood
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.repository.CartRepository
import com.example.foodapp.model.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel(private val foodRepository: FoodRepository , private val cartRepository: CartRepository):BaseViewModel() {
    private val _data = MutableLiveData<List<DetailFood>>()
    val detailFoodLiveData:LiveData<List<DetailFood>> = _data

    private val responseCart = MutableLiveData<String>()
    val addCartLiveData:LiveData<String> = responseCart

    fun getData(id_item:String){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getDetailFood(id_item)
                .collect {
                    _data.postValue(it)
                }
        }

    }

    fun addToCart(id_item: String , name:String , price:String , link_img:String){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.addToCart(id_item , name , price , link_img)
                .collect {

                    responseCart.postValue(it)

                }
        }
    }

    fun addFoodToDb(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.addFood(food)
        }
    }

    fun deleteFoodFromDb(food: Food){
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.deleteFood(food)
        }
    }
}