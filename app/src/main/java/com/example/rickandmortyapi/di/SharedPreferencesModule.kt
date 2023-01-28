package com.example.rickandmortyapi.di

import android.content.Context
import android.content.SharedPreferences
import com.example.rickandmortyapi.constants.Constants
import com.example.rickandmortyapi.data.preference.LanguageSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {
    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(
            Constants.RICK_AND_MORTY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun provideSessionManager(preferences: SharedPreferences) =
        LanguageSharedPreferences(preferences)
}