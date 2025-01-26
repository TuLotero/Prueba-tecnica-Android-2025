package com.tulotero.buscadorboletos.network

import com.tulotero.buscadorboletos.model.DataModel
import kotlinx.coroutines.delay
import retrofit2.http.Path
import retrofit2.http.Query
import kotlin.random.Random
import kotlin.text.filter
import kotlin.text.matches
import kotlin.text.replace
import kotlin.text.toRegex

private const val SIMULATED_NETWORK_DELAY = 500L

class MockApiService : ApiService {
    private val mockData by lazy { generateMockData() }

    override suspend fun getData(
        @Path("sorteo") id: Int,
        @Query("numero") numero: String,
        @Query("cantidadMinima") cantidadMinima: Int
    ): List<DataModel> {
        delay(SIMULATED_NETWORK_DELAY)
        return mockData
            .filter { dataModel ->
                val regex = numero.replace("_", ".")
                dataModel.numero.matches(regex.toRegex())
            }
            .filter {
                it.cantidad >= cantidadMinima
            }
    }

    private fun generateMockData(): List<DataModel> {
        val dataModels = mutableListOf<DataModel>()
        for (i in 0 until 200) {
            val cantidad = Random.nextInt(1, 100)
            val numeros = generateRandomNumberString()
            dataModels.add(DataModel(cantidad, numeros))
        }
        return dataModels
    }

    private fun generateRandomNumberString(): String {
        return (10000..99999).random().toString()
    }
}