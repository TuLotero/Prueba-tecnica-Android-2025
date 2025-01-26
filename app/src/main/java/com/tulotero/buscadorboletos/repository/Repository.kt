package com.tulotero.buscadorboletos.repository

import com.tulotero.buscadorboletos.model.DataModel
import com.tulotero.buscadorboletos.network.RetrofitInstance

class Repository {
    suspend fun getData(sorteo: Int, numero: String, cantidadMinima: Int): List<DataModel> {
        return RetrofitInstance.api.getData(sorteo, numero, cantidadMinima)
    }
}