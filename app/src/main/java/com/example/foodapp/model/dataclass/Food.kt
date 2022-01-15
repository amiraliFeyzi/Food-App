package com.example.foodapp.model.dataclass

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "foodFavorite")
data class Food(
    val category_name: String,
    val description: String?,
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val link_img: String,
    val name: String,
    val price: String
) : Parcelable