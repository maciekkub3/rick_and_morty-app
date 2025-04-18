package com.example.rickandmorty.ui.Screens.CharacterDetailsScreen

import com.example.rickandmorty.data.domain.models.Result

data class CharacterDetailsViewState(
    val isLoading: Boolean = false,
    val character: Result? = null,
    val error: String? = null
)