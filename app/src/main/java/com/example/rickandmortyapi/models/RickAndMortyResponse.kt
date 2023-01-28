package com.example.rickandmortyapi.models

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(

    @SerializedName("info") var info: Info,

    @SerializedName("results")
    var results: List<T>
)