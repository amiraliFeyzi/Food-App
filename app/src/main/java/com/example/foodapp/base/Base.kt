package com.example.foodapp.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.R
import com.example.foodapp.model.imageloading.ImageLoading
import org.koin.android.ext.android.inject

abstract class BaseActivity():AppCompatActivity(),FoodView{
    override val rootView: ConstraintLayout?
        get() {
            val viewGroup = window.decorView.findViewById(android.R.id.content) as ViewGroup
            if (viewGroup !is ConstraintLayout) {
                viewGroup.children.forEach {
                    if (it is ConstraintLayout)
                        return it
                }
                throw IllegalStateException("RootView must be instance of CoordinatorLayout")
            } else
                return viewGroup
        }
    override val viewContext: Context?
        get() = this
}

abstract class BaseFragment():Fragment(),FoodView{
    val imageLoading:ImageLoading by inject()

    override val rootView: ConstraintLayout?
        get() = view as ConstraintLayout
    override val viewContext: Context?
        get() = context
}

open class BaseViewModel() :ViewModel(){
    val progressbarLiveData = MutableLiveData<Boolean>()

}

interface FoodView{

    val viewContext: Context?
    val rootView:ConstraintLayout?

    fun showProgressBar(must:Boolean){
        rootView?.let {
            viewContext?.let { context ->
                var loadinView= it.findViewById<View>(R.id.loadingview)
                if (loadinView == null && must == true){
                    loadinView = LayoutInflater.from(context).inflate(R.layout.loading_view , it , false)
                    it.addView(loadinView)
                }
                loadinView.visibility = if (must) View.VISIBLE else View.GONE

            }

        }
    }


    fun showEmptyState(layoutResId:Int):View?{
        rootView?.let {
            viewContext?.let { viewContext->
                var emptyState= it.findViewById<View>(R.id.empty_state_root)

                if (emptyState == null){
                    emptyState = LayoutInflater.from(viewContext).inflate(layoutResId , rootView , false)
                    it.addView(emptyState)
                }

                emptyState.visibility = View.VISIBLE
                return emptyState

            }
        }
        return null
    }

}