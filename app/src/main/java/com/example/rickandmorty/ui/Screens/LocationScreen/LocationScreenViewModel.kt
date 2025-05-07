package com.example.rickandmorty.ui.Screens.LocationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.usecase.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationScreenViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(LocationViewState())
    val state: StateFlow<LocationViewState> = _state

    init {
        viewModelScope.launch {
            fetchLocations()
        }
    }

    private suspend fun fetchLocations() {
        _state.value = _state.value.copy(isLoading = true, error = null)
        try {
            val response = getLocationUseCase()
            _state.value = LocationViewState(isLoading = false, locations = response.results)
        } catch (e: Exception) {
            _state.value =
                LocationViewState(isLoading = false, error = e.message ?: "Error fetching locations")
        }
    }
}