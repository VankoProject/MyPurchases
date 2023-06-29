package com.kliachenko.mypurchases.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kliachenko.mypurchases.databinding.ActivityShoppingBinding
import com.kliachenko.mypurchases.domain.model.ShoppingItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingActivity : AppCompatActivity() {

    private var _binding: ActivityShoppingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fabAdd.setOnClickListener {
            AddShoppingDialog(this,
            object : AddDialogListener{
                override fun onAddButtonClick(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}