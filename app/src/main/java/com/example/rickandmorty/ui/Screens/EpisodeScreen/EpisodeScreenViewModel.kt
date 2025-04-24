package com.example.rickandmorty.ui.Screens.EpisodeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.usecase.GetEpisodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeScreenViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(EpisodeViewState())
    val state: StateFlow<EpisodeViewState> = _state

    init {
        viewModelScope.launch {
            fetchEpisodes()
        }
    }

    private suspend fun fetchEpisodes() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        try {
            val response = getEpisodeUseCase()
            _state.value = EpisodeViewState(isLoading = false, episodes = response.results)
        } catch (e: Exception) {
            _state.value =
                EpisodeViewState(isLoading = false, error = e.message ?: "Error fetching episodes")
        }
    }
}