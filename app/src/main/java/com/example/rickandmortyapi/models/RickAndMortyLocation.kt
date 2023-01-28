package com.example.rickandmortyapi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmortyapi.base.BaseDiffModel
import com.google.gson.annotations.SerializedName
@Entity
data class RickAndMortyLocation(
    @PrimaryKey
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
) : BaseDiffModel