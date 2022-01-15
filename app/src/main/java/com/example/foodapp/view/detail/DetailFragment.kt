package com.example.foodapp.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.base.EXTRA_KEY_DATA
import com.example.foodapp.databinding.FragmentDetailBinding
import com.example.foodapp.model.dataclass.Food
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private var _binding:FragmentDetailBinding?= null
    private val binding get() = _binding!!

    private val viewModel:DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val food: Food? = arguments?.getParcelable<Food>(EXTRA_KEY_DATA)

        viewModel.getData(food?.id.toString())

        binding.tvNameFood.text = food?.name
        binding.tvPriceFood.text = "$${food?.price}"
        binding.tvDesFood.text = food?.description

        viewModel.detailFoodLiveData.observe(viewLifecycleOwner){
            it.forEach { detailFood ->
                binding.tvTimeFood.text = detailFood.time
                binding.tvCaleryFood.text = detailFood.calery
                binding.tvDescription.text = detailFood.description
                binding.tvRateFood.text = detailFood.rate
                imageLoading.load(binding.ivFood , detailFood.link_img)
            }

        }

        binding.ivFavorite.setOnClickListener {
            food?.let{food->
                viewModel.addFoodToDb(food)

                Snackbar.make(it , "This Food Added to Favorite" , Snackbar.LENGTH_SHORT).show()

            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}