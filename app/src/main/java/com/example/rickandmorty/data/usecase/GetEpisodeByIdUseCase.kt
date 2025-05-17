package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.domain.models.Episode
import com.example.rickandmorty.data.network.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodeByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){
    suspend operator fun invoke(id: Int): Episode {
        return repository.getEpisodeById(id)
    }
}
