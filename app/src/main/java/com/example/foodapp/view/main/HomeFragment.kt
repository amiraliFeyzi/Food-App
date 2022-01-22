package com.example.foodapp.view.main

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.databinding.FragmentHomeBinding
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.base.EXTRA_KEY_DATA
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.view.common.FoodEventListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() , FoodEventListener{


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
        observeData(category)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTextSlider()


        var isCheck = false

        binding.chipBurger.setOnClickListener {
            category = "Burger"
            observeData(category)

            isCheck = !isCheck
            if(isCheck){
                binding.chipBurger.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.chipBurger.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            chipActiveCheck()
            isCheck = false
        }

        binding.chipBurger2.setOnClickListener {
            category = "Pizza"
            observeData(category)
            isCheck = !isCheck
            if(isCheck){
                binding.chipBurger2.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.chipBurger2.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.chipBurger2.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            chipActiveCheck()

            isCheck =false
        }

        binding.saladChip.setOnClickListener {
            category = "Salad"
            observeData(category)

            isCheck = !isCheck

            if(isCheck){
                binding.saladChip.chipBackgroundColor =  ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.red))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.white)))
            }else{
                binding.saladChip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.gray))
                binding.saladChip.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.black)))
            }

            chipActiveCheck()

            isCheck =false
        }



    }

    fun chipActiveCheck(){
        val idChipActive = binding.chipgroup.checkedChipId
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
    }

    fun setTextSlider(){
        val name:String = getColoredSpanned("Delivery" , "#FF000000")
        val food:String = getColoredSpanned("Food" , "#da6156")

        binding.tvTitleSlider.setText(Html.fromHtml(name + " " + food))

    }

    fun observeData(categoryName: String){
        viewModel.getData(categoryName)

        viewModel.homeDataLiveData.observe(viewLifecycleOwner){
            binding.rvHome.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.HORIZONTAL,false)
            binding.rvHome.adapter = AdapterFood(it , imageLoading , this)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getColoredSpanned(text: String, color: String): String {
        val input:String = "<font color=$color>$text</font>"
        return input
    }


    override fun onClickFood(food: Food) {
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_KEY_DATA , food)
        this.findNavController().navigate(R.id.action_homeFragment_to_detailFragment , bundle)
    }

    override fun onLongClickFood(food: Food) {
        TODO("Not yet implemented")
    }


}