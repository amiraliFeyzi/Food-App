package com.example.foodapp.model.imageloading

import com.example.foodapp.customviews.imageview.FoodImageView
import com.facebook.drawee.view.SimpleDraweeView
import java.lang.IllegalStateException

class FrescoImageLoading:ImageLoading {
    override fun load(imageView: FoodImageView, link: String) {
       if(imageView is SimpleDraweeView){
           imageView.setImageURI(link)
       }else{
           throw IllegalStateException("ImageView must be instance of SimpleDraweeView")
       }
    }
}