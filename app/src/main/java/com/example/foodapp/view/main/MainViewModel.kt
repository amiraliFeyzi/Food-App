package com.example.foodapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.model.Food
import com.example.foodapp.model.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class MainViewModel(val homeRepository: HomeRepository):BaseViewModel() {
    private val _data = MutableLiveData<List<Food>>()
    val homeDataLiveData:LiveData<List<Food>> = _data


    fun getData(categoryName:String){
        viewModelScope.launch (Dispatchers.IO){
            progressbarLiveData.postValue(true)
            homeRepository.getData(categoryName)
                .onCompletion {
                    progressbarLiveData.postValue(false)
                }
                .collect {
                _data.postValue(it)
            }
        }
    }
}