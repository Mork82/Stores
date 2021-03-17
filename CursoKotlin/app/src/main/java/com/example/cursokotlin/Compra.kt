package com.example.cursokotlin

import java.util.*

data class Compra(val id: Int) {
    private lateinit var fecha: Date
    private var total = 0.0

    constructor(id: Int, fecha: Date, total: Double) : this(id) {
        this.fecha = fecha
        this.total = total
    }

}
