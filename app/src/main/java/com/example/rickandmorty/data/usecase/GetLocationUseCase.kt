package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.LocationResponse
import com.example.rickandmorty.data.network.RickAndMortyRepository
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(): LocationResponse {
        return repository.getLocations()
    }
}