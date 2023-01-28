package com.example.rickandmortyapi.ui.fragments.location.description

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentLocationDescriptionBinding
import com.example.rickandmortyapi.ui.fragments.location.LocationViewModel
import com.example.rickandmortyapi.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationDescriptionFragment :
    BaseFragment<FragmentLocationDescriptionBinding, LocationViewModel>(
        R.layout.fragment_location_description
    ) {
    override val binding by viewBinding(FragmentLocationDescriptionBinding::bind)
    override val viewModel: LocationViewModel by activityViewModels()
    val args: LocationDescriptionFragmentArgs by navArgs()

    override fun setupRequests() {
        super.setupRequests()
        getIdLocation()
    }

    private fun getIdLocation() {
        viewModel.getIdLocation(args.getIdLocation).observe(viewLifecycleOwner) {
            binding.txtNameLocation.text = it.name
            binding.typeLocationTxt.text = it.type
            binding.txtDimensionLocation.text = it.dimension
            binding.txtCreatedLocation.text = it.created
        }
    }


}