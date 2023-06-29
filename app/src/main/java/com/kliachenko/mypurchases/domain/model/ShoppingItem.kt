package com.kliachenko.mypurchases.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


data class ShoppingItem(
    var name: String,
    var amount: Int
) {
    var id: Int? = null
}