package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.EpisodeResponse
import com.example.rickandmorty.data.network.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodeUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(): EpisodeResponse {
        return repository.getEpisodes()
    }

}