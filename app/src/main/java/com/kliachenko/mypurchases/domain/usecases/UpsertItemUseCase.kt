package com.kliachenko.mypurchases.domain.usecases

import com.kliachenko.mypurchases.domain.Repository
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class UpsertItemUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(item: ShoppingItem) {
        repository.upsertItem(item)
    }
}