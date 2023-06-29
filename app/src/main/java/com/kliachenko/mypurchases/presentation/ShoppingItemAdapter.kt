package com.kliachenko.mypurchases.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kliachenko.mypurchases.databinding.ShoppingItemBinding
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: MyViewModel
): RecyclerView.Adapter<ShoppingViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ShoppingItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShoppingViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.tvName.text = currentItem.name
        holder.binding.tvCount.text = "${currentItem.amount}"

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }

        holder.binding.ivPlus.setOnClickListener {
            currentItem.amount++
            viewModel.upsert(currentItem)
        }

        holder.binding.ivMinus.setOnClickListener {
            if(currentItem.amount > 0) {
                currentItem.amount--
                viewModel.upsert(currentItem)
            }

        }
    }
}