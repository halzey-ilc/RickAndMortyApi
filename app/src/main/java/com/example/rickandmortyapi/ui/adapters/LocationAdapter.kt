package com.example.rickandmortyapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemLocationBinding
import com.example.rickandmortyapi.base.BaseDiffUtilItemCallback
import com.example.rickandmortyapi.models.RickAndMortyLocation

class LocationAdapter(
    val onItemClick: (id: Int) -> Unit
) : PagingDataAdapter<RickAndMortyLocation, LocationAdapter.LocationViewHolder>(
    BaseDiffUtilItemCallback<RickAndMortyLocation>()
) {

    private lateinit var binding: ItemLocationBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LocationViewHolder {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemClick(id) }
            }
        }

        fun onBind(rickAndMortyLocations: RickAndMortyLocation) {
            with(binding) {
                txtNameLocation.text = rickAndMortyLocations.name
                typeLocationTxt.text = rickAndMortyLocations.type
                txtDimensionLocation.text = rickAndMortyLocations.dimension
                txtCreatedLocation.text = rickAndMortyLocations.created
            }

        }


    }
}