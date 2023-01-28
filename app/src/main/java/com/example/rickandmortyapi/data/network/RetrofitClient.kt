package com.example.rickandmortyapi.data.network

import com.example.rickandmortyapi.constants.Constants.BASE_URL
import com.example.rickandmortyapi.data.network.apiservice.CharacterApiService
import com.example.rickandmortyapi.data.network.apiservice.EpisodeApiService
import com.example.rickandmortyapi.data.network.apiservice.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideHttpLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService(): CharacterApiService {
        return retrofit.create(CharacterApiService::class.java)
    }
    fun provideEpisodeApiService(): EpisodeApiService {
        return retrofit.create(EpisodeApiService::class.java)
    }
    fun provideLocationApiService(): LocationApiService {
        return retrofit.create(LocationApiService::class.java)
    }


}