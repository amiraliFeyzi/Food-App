package com.example.foodapp.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.databinding.FragmentCartBinding
import com.example.foodapp.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment() {


    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel:FavoriteViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.foodLiveData.observe(viewLifecycleOwner){
            binding.rvFavrote.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.VERTICAL , false)
            binding.rvFavrote.adapter = FoodFavoriteAdapter(it , imageLoading)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}