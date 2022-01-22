package com.example.foodapp.customviews.toolbar

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.foodapp.R
import kotlinx.android.synthetic.main.view_toolbar.view.*

class FoodToolbar(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    init {
        inflate(context , R.layout.view_toolbar , this)

        if(attrs !=null){
            val attr = context.obtainStyledAttributes(attrs , R.styleable.FoodToolbar)
            val title = attr.getString(R.styleable.FoodToolbar_fd_title)

            if (title!=null && title.isNotEmpty()){
                toolbarTitleTv.text = title
            }

            attr.recycle()
        }
    }

}