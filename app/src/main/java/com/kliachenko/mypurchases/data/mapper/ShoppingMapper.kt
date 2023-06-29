package com.kliachenko.mypurchases.data.mapper

import androidx.lifecycle.MediatorLiveData
import com.kliachenko.mypurchases.data.database.ShoppingItemEntity
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class ShoppingMapper {

    fun convertItemDbEntityToShoppingItem(item: ShoppingItemEntity) =
        ShoppingItem(
            id = item.id,
            name = item.name,
            amount = item.amount
        )

    fun convertShoppingItemToItemDbEntity(item: ShoppingItem) =
        ShoppingItemEntity(
            id = item.id,
            name = item.name,
            amount = item.amount
        )

    fun convertListShoppingItemToListDbEntity(list: List<ShoppingItemEntity>) =
        list.map { convertItemDbEntityToShoppingItem(it) }
}