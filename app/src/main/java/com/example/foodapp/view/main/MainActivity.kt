package com.example.foodapp.view.main

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.navigation.fragment.NavHostFragment
import com.example.foodapp.R
import com.example.foodapp.base.BaseActivity
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigaiton()
    }

    private fun setBottomNavigaiton(){
        val navHostFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val popupMenu = PopupMenu(this , null)
        popupMenu.inflate(R.menu.menu_home)
        val menu = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu , navController)
    }

    private fun setIconColor(){

    }



}