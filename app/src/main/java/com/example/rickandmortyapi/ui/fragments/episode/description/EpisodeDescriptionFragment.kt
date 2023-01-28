package com.example.rickandmortyapi.ui.fragments.episode.description

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentEpisodeDescriptionBinding
import com.example.rickandmortyapi.ui.fragments.episode.EpisodeViewModel
import com.example.rickandmortyapi.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDescriptionFragment :
    BaseFragment<FragmentEpisodeDescriptionBinding, EpisodeViewModel>(
        R.layout.fragment_episode_description
    ) {
    override val binding by viewBinding(FragmentEpisodeDescriptionBinding::bind)
    override val viewModel: EpisodeViewModel by activityViewModels()
    val args: EpisodeDescriptionFragmentArgs by navArgs()

    override fun setupRequests() {
        super.setupRequests()
        fetchEpisode()
    }

    private fun fetchEpisode() {
        viewModel.getIdEpisode(args.getId).observe(viewLifecycleOwner) {
            binding.txtNameEpisodes.text = it.name
            binding.txtAirDateEpisodes.text = it.airDate
            binding.txtEpisodesEpisodes.text = it.episode
            binding.txtCreatedEpisodes.text = it.created
        }
    }
}