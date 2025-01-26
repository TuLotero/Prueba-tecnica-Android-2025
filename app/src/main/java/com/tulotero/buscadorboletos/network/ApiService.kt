package com.tulotero.buscadorboletos.network

import com.tulotero.buscadorboletos.model.DataModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users/lottery/decimos/{sorteo}")
    suspend fun getData(
        @Path("sorteo") id: Int,
        @Query("numero") numero: String,
        @Query("cantidadMinima") cantidadMinima: Int
    ): List<DataModel>
}

object RetrofitInstance {
    val api: ApiService by lazy {
        MockApiService()
    }
}