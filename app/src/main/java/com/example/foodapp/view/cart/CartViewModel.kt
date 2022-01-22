package com.example.foodapp.view.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.R
import com.example.foodapp.base.BaseViewModel
import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.dataclass.EmptyState
import com.example.foodapp.model.repository.CartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel(private val cartRepository: CartRepository):BaseViewModel() {

    private val _data = MutableLiveData<List<Cart>>()
    val cartListLiveData:LiveData<List<Cart>> = _data

    val emptyStateLiveData = MutableLiveData<EmptyState>()


    init {
        getCartList()
    }

    fun getCartList(){
        viewModelScope.launch (Dispatchers.IO){
            cartRepository.getCartList().collect {
                if (it.isNullOrEmpty()){
                    emptyStateLiveData.postValue(EmptyState(true , R.string.cartEmptyStateItem ))
                }else{
                    emptyStateLiveData.postValue(EmptyState(false ))
                    _data.postValue(it)
                }

            }
        }
    }


    fun deleteCart(id_item:String , name:String , price:String , link_img:String){
        viewModelScope.launch(Dispatchers.IO) {
            cartRepository.deleteCart(id_item , name , price, link_img)
            withContext(Dispatchers.Main){
                if (cartListLiveData.value.isNullOrEmpty()){
                       emptyStateLiveData.value = EmptyState(true , R.string.cartEmptyStateItem)
                }
            }


        }
    }


}