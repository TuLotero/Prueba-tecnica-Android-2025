package com.tulotero.buscadorboletos.repository

import com.tulotero.buscadorboletos.model.Boleto
import com.tulotero.buscadorboletos.network.RetrofitInstance

class Repository {
    suspend fun getData(sorteo: Int, numero: String, cantidadMinima: Int): List<Boleto> {
        return RetrofitInstance.api.getData(sorteo, numero, cantidadMinima)
    }
}