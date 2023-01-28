package com.example.rickandmortyapi.ui.fragments.character.description

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterDescriptionBinding
import com.example.rickandmortyapi.ui.fragments.character.CharacterViewModel
import com.example.rickandmortyapi.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDescriptionFragment :
    BaseFragment<FragmentCharacterDescriptionBinding, CharacterViewModel>(
        R.layout.fragment_character_description
    ) {

    override val binding by viewBinding(FragmentCharacterDescriptionBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private val args: CharacterDescriptionFragmentArgs by navArgs()

    override fun setupRequests() {
        super.setupRequests()
        fetchCharacter()
    }

    private fun fetchCharacter() {
        viewModel.fetchCharacter(args.getId).observe(viewLifecycleOwner) {
            Glide.with(binding.imageDescription)
                .load(it.image)
                .into(binding.imageDescription)
            binding.textNameDescription.text = it.name
        }
    }

}