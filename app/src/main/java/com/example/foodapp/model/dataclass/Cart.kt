package com.example.foodapp.model.dataclass

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cart(

    val id: Int,
    val link_img: String,
    val name: String,
    val price: Float,
    val id_item:Int
) : Parcelable