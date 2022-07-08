package com.oe.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Item(
    val itemName: String,
    val itemPrice: Double,
    val itemVat: Int,
    val itemBarcode: String,
    val timestamp: Long,
    @BsonId
    val id: String = ObjectId().toString()
)