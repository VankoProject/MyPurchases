package com.kliachenko.mypurchases.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.kliachenko.mypurchases.data.database.ShoppingDao
import com.kliachenko.mypurchases.data.mapper.convertListShoppingItemToListDbEntity
import com.kliachenko.mypurchases.data.mapper.convertShoppingItemToItemDbEntity
import com.kliachenko.mypurchases.domain.Repository
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class RepositoryImpl(
    private val dao: ShoppingDao,
) : Repository {

    override fun getAllShoppingItems(): LiveData<List<ShoppingItem>> =
        MediatorLiveData<List<ShoppingItem>>().apply {
            addSource(dao.getAllShoppingItems()) {
                value = convertListShoppingItemToListDbEntity(it)
            }
        }

    override suspend fun upsertItem(item: ShoppingItem) =
        dao.upsert(convertShoppingItemToItemDbEntity(item))

    override suspend fun deleteItem(item: ShoppingItem) {
        dao.delete(convertShoppingItemToItemDbEntity(item))
    }
}