package com.example.foodapp.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityInrtoBinding
import com.example.foodapp.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class InrtoActivity : AppCompatActivity() {
    lateinit var binding:ActivityInrtoBinding
    val viewModel:IntroViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInrtoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.sliderLiveData.observe(this){
            binding.slider.adapter = IntroAdapter(it)
            binding.sliderIndicator.setViewPager2(binding.slider)
        }

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
            finish()
        }



    }
}