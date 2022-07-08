package com.oe.data

import com.oe.data.model.Item
import org.litote.kmongo.coroutine.CoroutineDatabase

class ItemDataSourceImpl(
    private val db: CoroutineDatabase
): ItemDataSource {

    private val items = db.getCollection<Item>()

    override suspend fun getAllItems(): List<Item> {
        val i = items.find()
            .descendingSort(Item::timestamp)
            .toList()
        println(i)
        return i
    }

    override suspend fun getItem(id: String): Item {
        return items.findOneById(id)!!
    }

    override suspend fun insertItem(item: Item): Boolean {
        return items.insertOne(item).wasAcknowledged()
    }

    override suspend fun updateItem(item: Item): Boolean {
        return items.updateOneById(item.id, item).wasAcknowledged()
    }

    override suspend fun removeItem(itemID: String): Boolean {
        return items.deleteOneById(itemID).wasAcknowledged()
    }
}