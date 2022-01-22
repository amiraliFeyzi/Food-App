package com.example.foodapp.view.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.ItemCartBinding
import com.example.foodapp.model.dataclass.Cart
import com.example.foodapp.model.imageloading.ImageLoading

class CartFoodAdapter (val data:MutableList<Cart>, val imageLoading: ImageLoading , val cartEventListener: CartEventListener):RecyclerView.Adapter<CartFoodAdapter.ViewHolder>() {

    inner class ViewHolder(val binding:ItemCartBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cart: Cart){
            binding.tvFoodNameCart.text = cart.name
            binding.tvFoodPriceCart.text = "$${cart.price}"
            imageLoading.load(binding.ivFoodCart , cart.link_img)

            binding.btnDeleteCart.setOnClickListener {
                cartEventListener.onDeleteBtnClick(cart)
                deleteItem(cart , adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context) , parent , false))

    }

    fun deleteItem(cart: Cart , position: Int){
        notifyItemRemoved(position)
        data.remove(cart)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int  = data.size

    interface CartEventListener{
        fun onDeleteBtnClick(cart: Cart)
    }
}