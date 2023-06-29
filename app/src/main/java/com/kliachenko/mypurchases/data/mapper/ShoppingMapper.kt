package com.kliachenko.mypurchases.data.mapper

import androidx.lifecycle.MediatorLiveData
import com.kliachenko.mypurchases.data.database.ShoppingItemEntity
import com.kliachenko.mypurchases.domain.model.ShoppingItem

    fun convertItemDbEntityToShoppingItem(item: ShoppingItemEntity) =
        ShoppingItem(
            name = item.name,
            amount = item.amount,
        )

    fun convertShoppingItemToItemDbEntity(item: ShoppingItem) =
        ShoppingItemEntity(
            name = item.name,
            amount = item.amount,
            id = 0
        )

    fun convertListShoppingItemToListDbEntity(list: List<ShoppingItemEntity>) =
        list.map { convertItemDbEntityToShoppingItem(it) }
