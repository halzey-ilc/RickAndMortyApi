package com.example.rickandmortyapi.ui.fragments.character

import android.content.ContentValues.TAG
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickandmortyapi.base.BaseFragment
import com.example.rickandmortyapi.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
        R.layout.fragment_character
    ) {

    private val characterAdapter: CharacterAdapter = CharacterAdapter(
        this::onItemClick,
        this::onItemLongClick
    )
    override val viewModel: CharacterViewModel by activityViewModels()
    override val binding by viewBinding(FragmentCharacterBinding::bind)


    override fun setupRequests() {
        super.setupRequests()
        fetchCharacters()
    }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()

    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }

    }

    private fun fetchCharacters() {
        lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                characterAdapter.submitData(it)
             //   Log.e(TAG, "fetchCharacters: ", )
            }
        }
    }


    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDescriptionFragment(id)
        )
    }

    private fun onItemLongClick(photo: String) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDlalogFragment(photo)
        )
    }
}


