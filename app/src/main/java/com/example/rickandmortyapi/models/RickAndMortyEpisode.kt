package com.example.rickandmortyapi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmortyapi.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyEpisode(
    @PrimaryKey
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("episode")
    val episode: String,


    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
): BaseDiffModel
