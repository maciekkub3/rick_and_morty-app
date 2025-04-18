package com.example.rickandmorty.ui.Screens.MainScreen

import com.example.rickandmorty.data.domain.models.Result

data class MainViewState (
    val isLoading: Boolean = false,
    val characters: List<Result> = emptyList(),
    val error: String? = null,

    val search: String = "",
    val isSearching: Boolean = false
)