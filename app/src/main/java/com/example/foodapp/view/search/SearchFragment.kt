package com.example.foodapp.view.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.base.EXTRA_KEY_DATA
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.databinding.FragmentSearchBinding
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.view.common.FoodEventListener
import com.example.foodapp.view.main.AdapterFood
import org.koin.android.ext.android.inject


class SearchFragment : BaseFragment() ,FoodEventListener  {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel:SearchViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val a = 0
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.search(p0.toString())
                viewModel.searchLiveData.observe(viewLifecycleOwner){
                    binding.rvSearch.layoutManager = GridLayoutManager(requireContext() , 2 )
                    binding.rvSearch.adapter = AdapterFood(it , imageLoading   , this@SearchFragment)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClickFood(food: Food) {
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_KEY_DATA , food)
        this.findNavController().navigate(R.id.action_searchFragment_to_detailFragment , bundle)
    }

    override fun onLongClickFood(food: Food) {
        TODO("Not yet implemented")
    }
}