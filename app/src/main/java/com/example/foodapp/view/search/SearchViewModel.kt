package com.example.foodapp.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.model.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(val searchRepository: SearchRepository):BaseViewModel() {
    private val _data = MutableLiveData<List<Food>>()
    val searchLiveData:LiveData<List<Food>> = _data

    fun search(name:String){
       viewModelScope.launch(Dispatchers.IO) {
           searchRepository.getSearch(name).collect {
               _data.postValue(it)
           }
       }
    }
}