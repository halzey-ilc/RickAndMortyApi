package com.example.rickandmortyapi.ui.fragments.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapi.data.repositories.EpisodeRepository
import com.example.rickandmortyapi.models.RickAndMortyEpisode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : ViewModel() {

    fun fetchEpisode(): Flow<PagingData<RickAndMortyEpisode>> {
        return repository.fetchEpisode().cachedIn(viewModelScope)
    }


    fun getIdEpisode(id: Int) = repository.getIdEpisode(id)

}