package com.kliachenko.mypurchases.domain.usecases

import androidx.lifecycle.LiveData
import com.kliachenko.mypurchases.domain.Repository
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class GetAllShoppingItemsUseCase(
    private val repository: Repository
) {

    operator fun invoke(): LiveData<List<ShoppingItem>> {
        return repository.getAllShoppingItems()
    }
}