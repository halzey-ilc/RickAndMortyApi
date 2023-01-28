package com.example.rickandmortyapi.data.network.apiservice

import com.example.rickandmortyapi.models.RickAndMortyLocation
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun getListLocation(
        @Query("page")  page: Int,
        @Query("limit") size: Int
    ): RickAndMortyResponse<RickAndMortyLocation>

    @GET("api/location/{id}")
    fun episode(
        @Path("id") id: Int
    ): Call<RickAndMortyLocation>


}
