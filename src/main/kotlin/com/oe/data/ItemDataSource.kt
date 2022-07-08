package com.oe.data

import com.oe.data.model.Item

interface ItemDataSource {

    suspend fun getAllItems(): List<Item>

    suspend fun getItem(id: String): Item

    suspend fun insertItem(item: Item): Boolean

    suspend fun updateItem(item: Item): Boolean

    suspend fun removeItem(itemID: String): Boolean

}