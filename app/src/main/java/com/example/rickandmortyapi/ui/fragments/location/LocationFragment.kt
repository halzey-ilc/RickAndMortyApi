package com.example.rickandmortyapi.ui.fragments.location

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentLocationBinding
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(
    R.layout.fragment_location
) {
    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    private val locationAdapter = LocationAdapter(this::onItemClick)

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = locationAdapter
        }
    }

    override fun setupRequests() {
        super.setupRequests()
        fetchLocation()
    }

    private fun fetchLocation() {
        lifecycleScope.launch {
            viewModel.fetchEpisode().collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationFragmentToLocationDescriptionFragment(
                id
            )
        )
    }

}