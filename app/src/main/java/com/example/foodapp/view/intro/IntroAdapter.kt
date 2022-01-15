package com.example.foodapp.view.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemIntroBinding
import com.example.foodapp.model.dataclass.Slider

class IntroAdapter(val data:List<Slider>) : RecyclerView.Adapter<IntroAdapter.ViewHolder>() {

    inner class ViewHolder(val binding:ItemIntroBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(slider: Slider){
            binding.titleInformatio.text = slider.title
            binding.descriptionInformation.text = slider.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemIntroBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int  = data.size
}