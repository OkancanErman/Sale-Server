package com.oe.sale

import com.oe.data.ItemDataSource
import com.oe.data.model.Item

class SaleController(
    private val itemDataSource: ItemDataSource
) {

    suspend fun getAllItems(): List<Item> {
        return itemDataSource.getAllItems()
    }

    suspend fun insertItem(item: Item): Boolean {
        return itemDataSource.insertItem(item)
    }

    suspend fun updateItem(item: Item): Boolean {
        return itemDataSource.updateItem(item)
    }

    suspend fun deleteItem(itemID: String): Boolean {
        return itemDataSource.removeItem(itemID)
    }

}