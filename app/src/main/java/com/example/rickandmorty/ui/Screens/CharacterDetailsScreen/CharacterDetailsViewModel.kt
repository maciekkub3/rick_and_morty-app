package com.example.rickandmorty.ui.Screens.CharacterDetailsScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.rickandmorty.data.usecase.GetCharacterByIdUseCase
import com.example.rickandmorty.navigation.CharacterDetailsScreenRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailsViewState())
    val state: StateFlow<CharacterDetailsViewState> = _state

    val args = savedStateHandle.toRoute<CharacterDetailsScreenRoute>()

    init {
        fetchCharacter(args.characterId)
    }

    private fun fetchCharacter(id: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                val response = getCharacterByIdUseCase(id)
                Log.d("CharacterDetailsVM", "Fetched character: $response")
                _state.value = CharacterDetailsViewState(isLoading = false, character = response)

            } catch (e: Exception) {
                Log.e("CharacterDetailsVM", "Error: ${e.message}", e)
                _state.value = CharacterDetailsViewState(
                    isLoading = false,
                    error = e.message ?: "Error fetching characters"
                )
            }
        }
    }
}