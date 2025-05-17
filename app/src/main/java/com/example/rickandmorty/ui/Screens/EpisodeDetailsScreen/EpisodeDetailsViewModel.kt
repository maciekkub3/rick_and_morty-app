package com.example.rickandmorty.ui.Screens.EpisodeDetailsScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.rickandmorty.data.usecase.GetCharacterListByIdUseCase
import com.example.rickandmorty.data.usecase.GetEpisodeByIdUseCase
import com.example.rickandmorty.navigation.EpisodeDetailsScreenRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase,
    private val getCharacterListByIdUseCase: GetCharacterListByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(EpisodeDetailsViewState())
    val state: StateFlow<EpisodeDetailsViewState> = _state

    val args = savedStateHandle.toRoute<EpisodeDetailsScreenRoute>()

    init {
        fetchEpisode(args.episodeId)
    }

    private fun fetchEpisode(id: Int) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                val response = getEpisodeByIdUseCase(id)
                Log.d("EpisodeDetailsVM", "Fetched episode: $response")
                _state.value = EpisodeDetailsViewState(isLoading = false, episode = response)
                val characterIds = response.characters.map { it.split("/").last().toInt() }
                val characters = getCharacterListByIdUseCase(characterIds)
                _state.value = EpisodeDetailsViewState(
                    isLoading = false,
                    episode = response,
                    characters = characters
                )


            } catch (e: Exception) {
                Log.e("EpisodeDetailsVM", "Error: ${e.message}", e)
                _state.value = EpisodeDetailsViewState(
                    isLoading = false,
                    error = e.message ?: "Error fetching episode"
                )
            }
        }
    }





}