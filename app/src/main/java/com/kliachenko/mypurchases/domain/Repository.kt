package com.kliachenko.mypurchases.domain

import androidx.lifecycle.LiveData
import com.kliachenko.mypurchases.data.database.ShoppingItemEntity
import com.kliachenko.mypurchases.domain.model.ShoppingItem

interface Repository {

    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

    suspend fun upsertItem(item: ShoppingItem)

    suspend fun deleteItem(item: ShoppingItem)


}