package com.example.foodapp.model.imageloading

import com.example.foodapp.customviews.imageview.FoodImageView

interface ImageLoading {
    fun load(imageView: FoodImageView, link:String)
}