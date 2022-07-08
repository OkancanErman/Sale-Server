package com.oe.routes

import com.oe.data.model.Item
import com.oe.sale.SaleController
import io.ktor.application.*
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.Conflict
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAllItems(roomController: SaleController) {
    get("/items") {
        call.respond(OK, roomController.getAllItems())
    }
}

fun Route.addItem(roomController: SaleController) {
    post("/additem") {
        val item = try {
            call.receive<Item>()
        } catch (e: ContentTransformationException) {
            call.respond(BadRequest)
            return@post
        }
        if(roomController.insertItem(item)) {
            call.respond(OK)
        } else {
            call.respond(Conflict)
        }
    }
}

fun Route.updateItem(roomController: SaleController) {
    post("/updateitem") {
        val request = try {
            call.receive<Item>()
        } catch(e: ContentTransformationException) {
            call.respond(BadRequest)
            return@post
        }
        if(roomController.updateItem(request)) {
            call.respond(OK)
        } else {
            call.respond(Conflict)
        }
    }
}

fun Route.deleteItem(roomController: SaleController) {
    post("/deleteitem") {
        val request = try {
            call.receive<String>()
        } catch(e: ContentTransformationException) {
            call.respond(BadRequest)
            return@post
        }
        if(roomController.deleteItem(request)) {
            call.respond(OK)
        } else {
            call.respond(Conflict)
        }
    }
}

