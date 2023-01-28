package com.example.rickandmortyapi.di

import android.content.Context
import com.example.rickandmortyapi.data.db.AppDatabase
import com.example.rickandmortyapi.data.db.RoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun roomClient() = RoomClient()

    @Singleton
    @Provides
    fun provideGetDB(@ApplicationContext context: Context, roomClient: RoomClient) =
        roomClient.provideRoom(context)

    @Singleton
    @Provides
    fun provideCharacters(appDatabase: AppDatabase, roomClient: RoomClient) =
        roomClient.provideCharacterDao(appDatabase)

    @Singleton
    @Provides
    fun provideEpisode(appDatabase: AppDatabase, roomClient: RoomClient) =
        roomClient.provideEpisodeDao(appDatabase)
}


