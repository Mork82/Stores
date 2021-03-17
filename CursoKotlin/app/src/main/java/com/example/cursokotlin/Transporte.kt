package com.example.cursokotlin

abstract class Transporte {
    private lateinit var color: Color
    private  var capacidad:Int=0
    private lateinit var marca:String

}
enum class Color{
    ROJO,AZUL,VERDE,ROSA
}