package com.example.rickandmortyapi.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmortyapi.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
data class RickAndMortyCharacters(

    @PrimaryKey
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String
): BaseDiffModel