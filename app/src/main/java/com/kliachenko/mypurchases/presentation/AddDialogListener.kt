package com.kliachenko.mypurchases.presentation

import com.kliachenko.mypurchases.domain.model.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClick(item: ShoppingItem)

}