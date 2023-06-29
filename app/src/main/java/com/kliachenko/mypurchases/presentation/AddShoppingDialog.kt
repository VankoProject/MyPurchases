package com.kliachenko.mypurchases.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.kliachenko.mypurchases.databinding.DialogAddShoppingItemBinding
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class AddShoppingDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    private var _binding: DialogAddShoppingItemBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(
                    context,
                    "Please enter all the information",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding = null
    }

}