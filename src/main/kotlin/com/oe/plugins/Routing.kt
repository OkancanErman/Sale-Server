package com.oe.plugins

import com.oe.sale.SaleController
import com.oe.routes.*
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val roomController by inject<SaleController>()

    install(Routing) {
        getAllItems(roomController)
        addItem(roomController)
        deleteItem(roomController)
        updateItem(roomController)
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }

}
