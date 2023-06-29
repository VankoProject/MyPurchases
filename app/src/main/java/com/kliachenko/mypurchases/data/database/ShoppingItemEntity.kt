package com.kliachenko.mypurchases.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
)
