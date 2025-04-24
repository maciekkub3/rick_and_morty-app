package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.CharacterResponse
import com.example.rickandmorty.data.network.RickAndMortyRepository
import com.example.rickandmorty.data.usecase.GetCharacterUseCaseMapper.toDomain
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(): CharacterResponse {
        return repository.getCharacters().toDomain()
    }
}
