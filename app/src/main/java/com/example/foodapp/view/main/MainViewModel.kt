package com.example.foodapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.model.Burger
import com.example.foodapp.model.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(val homeRepository: HomeRepository):BaseViewModel() {
    private val _data = MutableLiveData<List<Burger>>()
    val HomeDataLiveData:LiveData<List<Burger>> = _data


    fun getData(categoryName:String){
        viewModelScope.launch (Dispatchers.IO){
            homeRepository.getData(categoryName).collect {
                _data.postValue(it)
            }
        }
    }
}