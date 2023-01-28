package com.example.rickandmortyapi.data.network.apiservice

import com.example.rickandmortyapi.models.RickAndMortyCharacters
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun getListCharacter(
        @Query("page") page: Int,
        @Query("limit") size: Int
    ): RickAndMortyResponse<RickAndMortyCharacters>

    @GET("api/character/{id}")
    fun character(
        @Path("id") id: Int
    ): RickAndMortyCharacters

}