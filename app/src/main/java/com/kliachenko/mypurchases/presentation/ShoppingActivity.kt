package com.kliachenko.mypurchases.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kliachenko.mypurchases.databinding.ActivityShoppingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingActivity : AppCompatActivity() {

    private var _binding: ActivityShoppingBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}