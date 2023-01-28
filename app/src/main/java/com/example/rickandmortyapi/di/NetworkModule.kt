package com.example.rickandmortyapi.di

import com.example.rickandmortyapi.data.network.RetrofitClient
import com.example.rickandmortyapi.data.network.apiservice.CharacterApiService
import com.example.rickandmortyapi.data.network.apiservice.EpisodeApiService
import com.example.rickandmortyapi.data.network.apiservice.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
// ojeckt класс создается при комприлирования кода это типо как singleTon
//
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun fetchCharacterApi(retrofitClient: RetrofitClient) =
        retrofitClient.provideCharacterApiService()

    @Singleton
    @Provides
    fun fetchEpisodeApi(retrofitClient: RetrofitClient) =
        retrofitClient.provideEpisodeApiService()

    @Singleton
    @Provides
    fun fetchLocationApi(retrofitClient: RetrofitClient) =
        retrofitClient.provideLocationApiService()

}