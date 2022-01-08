package com.example.foodapp.view.main

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.databinding.FragmentHomeBinding
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.view.main.AdapterFood
import com.example.foodapp.view.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment(){


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var category = "Burger"
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.chipBurger.isChecked = true
        binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
        binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))

        category = "Burger"
        viewModel.getData(category)

        viewModel.homeDataLiveData.observe(viewLifecycleOwner){
            binding.rvHome.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL,false)
            binding.rvHome.adapter = AdapterFood(it , imageLoading)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTextSlider()
        var isCheck = false

        binding.chipBurger.setOnClickListener {
            category = "Burger"
            viewModel.getData(category)

            viewModel.homeDataLiveData.observe(viewLifecycleOwner){
                binding.rvHome.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL,false)
                binding.rvHome.adapter = AdapterFood(it , imageLoading)
            }
            isCheck = !isCheck
            val idChipActive = binding.chipgroup.checkedChipId
            if(isCheck){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.chipBurger.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger.id){
                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger2.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.saladChip.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            isCheck = false
        }

        binding.chipBurger2.setOnClickListener {
            category = "Pizza"

            isCheck = !isCheck
            val idChipActive = binding.chipgroup.checkedChipId
            if(isCheck){
                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.chipBurger2.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger.id){
                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger2.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.saladChip.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            isCheck =false
        }

        binding.saladChip.setOnClickListener {
            category = "Salad"
            viewModel.getData(category)

            viewModel.homeDataLiveData.observe(viewLifecycleOwner){
                binding.rvHome.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL,false)
                binding.rvHome.adapter = AdapterFood(it , imageLoading)
            }
            isCheck = !isCheck
            val idChipActive = binding.chipgroup.checkedChipId
            if(isCheck){
                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.saladChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger.id){
                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.chipBurger2.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            if (idChipActive == binding.saladChip.id){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))

                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            isCheck =false
        }



    }

    fun setTextSlider(){
        val name:String = getColoredSpanned("Delivery" , "#FF000000")
        val food:String = getColoredSpanned("Food" , "#da6156")

        binding.tvTitleSlider.setText(Html.fromHtml(name + " " + food))

    }







    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getColoredSpanned(text: String, color: String): String {
        val input:String = "<font color=$color>$text</font>"
        return input
    }



}