package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.network.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){
    suspend operator fun invoke(id: Int): Character {
        return repository.getCharacterById(id)
    }
}
