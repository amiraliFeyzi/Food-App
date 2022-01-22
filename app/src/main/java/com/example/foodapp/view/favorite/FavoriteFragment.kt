package com.example.foodapp.view.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.base.BaseFragment
import com.example.foodapp.base.EXTRA_KEY_DATA
import com.example.foodapp.databinding.FragmentFavoriteBinding
import com.example.foodapp.model.dataclass.Food
import com.example.foodapp.view.common.FoodEventListener
import kotlinx.android.synthetic.main.view_emptystate_favorite.*
import kotlinx.android.synthetic.main.view_emptystate_favorite.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment(),FoodEventListener {


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
            binding.rvFavrote.adapter = FoodFavoriteAdapter(it as MutableList<Food> , imageLoading  , this)
        }

        viewModel.emptyStateLiveData.observe(viewLifecycleOwner){
            if (it.mustShow){
                val emptyState = showEmptyState(R.layout.view_emptystate_favorite)
                emptyState?.let {view->
                    view.tv_message_emptyState.text = getString(it.messageResId)
                }
            }else{
                empty_state_root?.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onClickFood(food: Food) {
        val bundle = Bundle()
        bundle.putParcelable(EXTRA_KEY_DATA , food)
        this.findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment , bundle)
    }

    override fun onLongClickFood(food: Food) {
        viewModel.deleteFood(food)
    }

}