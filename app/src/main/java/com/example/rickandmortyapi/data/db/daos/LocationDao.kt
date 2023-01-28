package com.example.rickandmortyapi.data.db.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapi.models.RickAndMortyLocation

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RickAndMortyLocation>)

    @Query("SELECT * FROM rickandmortylocation")
    fun getAllDoggoModel(): PagingSource<Int, RickAndMortyLocation>

    @Query("DELETE FROM rickandmortylocation")
    suspend fun clearRemoteKeys()

}