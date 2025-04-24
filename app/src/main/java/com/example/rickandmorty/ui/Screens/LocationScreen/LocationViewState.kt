package com.example.rickandmorty.ui.Screens.LocationScreen

import com.example.rickandmorty.data.domain.models.Location

data class LocationViewState(
    val isLoading: Boolean = false,
    val locations: List<Location> = emptyList(),
    val error: String? = null,
)