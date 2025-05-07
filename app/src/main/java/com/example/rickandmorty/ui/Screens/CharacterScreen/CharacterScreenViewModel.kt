package com.example.rickandmorty.ui.Screens.CharacterScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterScreenViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterViewState())
    val state: StateFlow<CharacterViewState> = _state

    init {
        viewModelScope.launch {
            fetchCharacters()
        }
    }

    private suspend fun fetchCharacters() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        try {
            val response = getCharacterUseCase()
            _state.value = CharacterViewState(isLoading = false, characters = response.results)
        } catch (e: Exception) {
            _state.value =
                CharacterViewState(isLoading = false, error = e.message ?: "Error fetching characters")
        }
    }
}