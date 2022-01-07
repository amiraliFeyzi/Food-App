package com.example.foodapp.model.imageloading

import com.facebook.drawee.view.SimpleDraweeView

interface ImageLoading {
    fun load(imageView: FoodImageView , link:String)
}