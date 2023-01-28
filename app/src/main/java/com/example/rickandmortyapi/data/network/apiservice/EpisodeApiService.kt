package com.example.rickandmortyapi.data.network.apiservice

import com.example.rickandmortyapi.models.RickAndMortyEpisode
import com.example.rickandmortyapi.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun getListEpisode(
        @Query("page") page: Int,
        @Query("limit") size: Int
    ): RickAndMortyResponse<RickAndMortyEpisode>

    @GET("api/episode/{id}")
    fun episode(
        @Path("id") id: Int
    ): Call<RickAndMortyEpisode>

}