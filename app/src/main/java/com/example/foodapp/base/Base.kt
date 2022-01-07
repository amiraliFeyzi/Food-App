package com.example.foodapp.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.imageloading.ImageLoading
import org.koin.android.ext.android.inject

abstract class BaseActivity():AppCompatActivity(),View{
}

abstract class BaseFragment():Fragment(),View{
    val imageLoading:ImageLoading by inject()
}

open class BaseViewModel() :ViewModel(){


}

interface View{

}