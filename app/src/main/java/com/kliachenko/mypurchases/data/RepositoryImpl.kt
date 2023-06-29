package com.kliachenko.mypurchases.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.kliachenko.mypurchases.data.database.ShoppingDatabase
import com.kliachenko.mypurchases.data.mapper.ShoppingMapper
import com.kliachenko.mypurchases.domain.Repository
import com.kliachenko.mypurchases.domain.model.ShoppingItem

class RepositoryImpl(
    private val db: ShoppingDatabase,
    private val mapper: ShoppingMapper
) : Repository {

    override fun getAllShoppingItems(): LiveData<List<ShoppingItem>> =
        MediatorLiveData<List<ShoppingItem>>().apply {
            addSource(db.getShoppingDao().getAllShoppingItems()) {
                value = mapper.convertListShoppingItemToListDbEntity(it)
            }
        }

    override suspend fun upsertItem(item: ShoppingItem) =
        db.getShoppingDao().upsert(mapper.convertShoppingItemToItemDbEntity(item))

    override suspend fun deleteItem(item: ShoppingItem) {
        db.getShoppingDao().delete(mapper.convertShoppingItemToItemDbEntity(item))
    }
}