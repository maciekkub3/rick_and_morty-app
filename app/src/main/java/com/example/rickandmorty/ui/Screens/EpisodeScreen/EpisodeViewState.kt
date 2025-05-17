package com.example.rickandmorty.ui.Screens.EpisodeScreen

import com.example.rickandmorty.data.domain.models.Episode

data class EpisodeViewState(
    val isLoading: Boolean = false,
    val episodes: List<Episode> = emptyList(),
    val error: String? = null,
    val selectedSeason: Int? = null
)