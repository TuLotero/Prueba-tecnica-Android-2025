package com.tulotero.buscadorboletos.network

import com.tulotero.buscadorboletos.model.Boleto
import kotlinx.coroutines.delay
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Locale
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random
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
    ): List<Boleto> {
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

    private fun generateMockData(): List<Boleto> {
        val boletos = mutableListOf<Boleto>()
        for (i in 0 until 200) {
            val cantidad = Random.nextInt(1, 100)
            val numeros = generateRandomNumberString()
            val (latitude, longitude) = generateRandomCoordinates()
            boletos.add(Boleto(cantidad, numeros, latitude, longitude))
        }
        return boletos
    }

    private fun generateRandomNumberString(): String {
        return String.format(Locale.getDefault(), "%05d", (0..99999).random())
    }

    private fun generateRandomCoordinates(): Pair<Double, Double> {
        val minLatitude = 43.74
        val maxLatitude = 35.98
        val minLongitude = -9.0
        val maxLongitude = -2.33
        val latitude = Random.nextDouble(minLatitude, maxLatitude)
        val longitude = Random.nextDouble(minLongitude, maxLongitude)
        return Pair(latitude, longitude)
    }
}