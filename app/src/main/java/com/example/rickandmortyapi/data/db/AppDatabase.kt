package com.example.rickandmortyapi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapi.data.db.daos.CharacterDao
import com.example.rickandmortyapi.data.db.daos.EpisodeDao
import com.example.rickandmortyapi.data.db.daos.LocationDao
import com.example.rickandmortyapi.data.db.daos.RemoteKeysDao
import com.example.rickandmortyapi.models.RemoteKeys
import com.example.rickandmortyapi.models.RickAndMortyCharacters
import com.example.rickandmortyapi.models.RickAndMortyEpisode
import com.example.rickandmortyapi.models.RickAndMortyLocation

@Database(
    entities = arrayOf(
        RickAndMortyCharacters::class,
        RemoteKeys::class,
        RickAndMortyEpisode::class,
        RickAndMortyLocation::class
    ), version = 3, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun getRepoDao(): RemoteKeysDao
    fun lastUpdated(): Byte {
        return 3
    }

}