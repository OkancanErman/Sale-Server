package com.oe.di

import com.oe.data.ItemDataSource
import com.oe.data.ItemDataSourceImpl
import com.oe.sale.SaleController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("item_db")
    }
    single<ItemDataSource> {
        ItemDataSourceImpl(get())
    }
    single {
        SaleController(get())
    }
}