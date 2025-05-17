package com.example.rickandmorty.ui.Screens.EpisodeDetailsScreen

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.domain.models.Episode


data class EpisodeDetailsViewState(
    val isLoading: Boolean = false,
    val episode: Episode? = null,
    val error: String? = null,
    val characters: List<Character> = emptyList(),
)