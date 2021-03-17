package com.example.cursokotlin

data class Articulo private constructor(val id: Int) {

    private lateinit var marca: String
    private lateinit var codigoBarras: String
    private var stock: Int = 0

    constructor(id: Int, marca: String) : this(id) {
        this.marca = marca
    }

    constructor(id: Int, marca: String,codigoBarras:String) : this(id,marca){
        this.codigoBarras=codigoBarras
    }

    constructor(id: Int,marca: String,codigoBarras: String,stock:Int):this(id,marca, codigoBarras){
        this.stock=stock
    }

}
