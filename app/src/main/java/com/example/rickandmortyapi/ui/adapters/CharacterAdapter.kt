package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.ItemCharacterBinding
import com.example.rickandmortyapi.base.BaseDiffUtilItemCallback
import com.example.rickandmortyapi.models.RickAndMortyCharacters

class CharacterAdapter(
    val onItemClick: (id: Int) -> Unit,
    val onItemLongClick: (photo: String) -> Unit
) : PagingDataAdapter<RickAndMortyCharacters, CharacterAdapter.CharacterViewHolder>(
    BaseDiffUtilItemCallback<RickAndMortyCharacters>()
) {
    private lateinit var binding: ItemCharacterBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }


    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemClick(id) }
            }

            binding.imageItemCharacter.setOnLongClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemLongClick(image) }
                false
            }
        }


        fun onBind(rickAndMortyCharacters: RickAndMortyCharacters) {
            with(binding) {
                Glide
                    .with(imageItemCharacter)
                    .load(rickAndMortyCharacters.image)
                    .into(imageItemCharacter)
                textItemCharacter.text = rickAndMortyCharacters.name
            }
        }

    }
}