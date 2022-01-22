package com.example.foodapp.view.cart

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
import com.example.foodapp.model.dataclass.Cart
import kotlinx.android.synthetic.main.view_emptystate_cart.*
import kotlinx.android.synthetic.main.view_emptystate_cart.view.*
import kotlinx.android.synthetic.main.view_emptystate_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CartFragment : BaseFragment(),CartFoodAdapter.CartEventListener {

    private var _binding:FragmentCartBinding? = null
    private val binding get() = _binding!!

    private val viewModel:CartViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCartBinding.inflate(inflater , container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.emptyStateLiveData.observe(viewLifecycleOwner){
            if (it.mustShow){
                val emptyState = showEmptyState(R.layout.view_emptystate_cart)
                emptyState?.let { view->
                    emptyState.tv_message_emptyState_cart.text  =getString(it.messageResId)

                }
            }else{
               empty_state_root_cart?.visibility = View.GONE
            }
        }

        viewModel.cartListLiveData.observe(viewLifecycleOwner){
            binding.rvCart.layoutManager = LinearLayoutManager(requireContext() , RecyclerView.VERTICAL , false)
            binding.rvCart.adapter = CartFoodAdapter(it as MutableList<Cart> , imageLoading , this )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDeleteBtnClick(cart: Cart) {
       viewModel.deleteCart(cart.id_item.toString() ,cart.name ,cart.price.toString() , cart.link_img)
    }

}