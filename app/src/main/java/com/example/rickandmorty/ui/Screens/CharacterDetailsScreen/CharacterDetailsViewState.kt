package com.example.rickandmorty.ui.Screens.CharacterDetailsScreen

import com.example.rickandmorty.data.domain.models.Character

data class CharacterDetailsViewState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String? = null
)