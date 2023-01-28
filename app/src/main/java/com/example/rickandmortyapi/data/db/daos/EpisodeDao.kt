package com.example.rickandmortyapi.data.db.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapi.models.RickAndMortyEpisode

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RickAndMortyEpisode>)

    @Query("SELECT * FROM rickandmortyepisode")
    fun getAllDoggoModel(): PagingSource<Int, RickAndMortyEpisode>

    @Query("DELETE FROM rickandmortyepisode")
    suspend fun clearRemoteKeys()

}