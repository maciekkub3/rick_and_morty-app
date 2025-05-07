package com.example.rickandmorty.ui.Screens.CharacterScreen

import com.example.rickandmorty.data.domain.models.Character

data class CharacterViewState (
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String? = null,

    val search: String = "",
    val isSearching: Boolean = false
)