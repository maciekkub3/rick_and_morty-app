package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.network.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterListByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(id: List<Int>): List<Character> {
        return repository.getMultipleCharactersById(id)
    }
}