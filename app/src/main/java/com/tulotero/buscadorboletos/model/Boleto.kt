package com.tulotero.buscadorboletos.model

data class Boleto(
    val cantidad: Int,
    val numero: String,
    val adminLatitude: Double,
    val adminLongitude: Double
)