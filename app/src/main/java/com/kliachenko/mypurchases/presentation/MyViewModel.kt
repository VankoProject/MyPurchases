package com.kliachenko.mypurchases.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kliachenko.mypurchases.domain.model.ShoppingItem
import com.kliachenko.mypurchases.domain.usecases.DeleteItemUseCases
import com.kliachenko.mypurchases.domain.usecases.GetAllShoppingItemsUseCase
import com.kliachenko.mypurchases.domain.usecases.UpsertItemUseCase
import kotlinx.coroutines.launch

class MyViewModel(
    private val upsertItemUseCase: UpsertItemUseCase,
    private val deleteItemUseCases: DeleteItemUseCases,
    private val getAllShoppingItemsUseCase: GetAllShoppingItemsUseCase
): ViewModel() {


    fun getAllShoppingItems() = getAllShoppingItemsUseCase


    fun upsert(item: ShoppingItem) =
        viewModelScope.launch {
            upsertItemUseCase(item)
        }

    fun delete(item: ShoppingItem) =
        viewModelScope.launch {
            deleteItemUseCases(item)
        }
}