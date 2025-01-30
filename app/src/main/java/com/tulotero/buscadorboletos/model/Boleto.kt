package com.tulotero.buscadorboletos.model

import android.location.Location

data class Boleto(
    val cantidad: Int,
    val numero: String,
    val adminLatitude: Double,
    val adminLongitude: Double
)