package com.example.rickandmortyapi.ui.fragments.episode

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentEpisodeBinding
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(
    R.layout.fragment_episode
) {
    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by activityViewModels()
    private val episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = episodeAdapter
        }
    }


    override fun setupRequests() {
        super.setupRequests()
        fetchEpidose()
    }

    private fun fetchEpidose() {
        lifecycleScope.launch {
            viewModel.fetchEpisode().collectLatest {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDescriptionFragment(id)
        )
    }

}