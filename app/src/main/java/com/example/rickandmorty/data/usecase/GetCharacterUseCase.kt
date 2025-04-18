package com.example.rickandmorty.data.usecase

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.network.RickAndMortyRepository
import com.example.rickandmorty.data.network.models.CharacterDto
import com.example.rickandmorty.data.usecase.GetCharacterUseCaseMapper.toDomain
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(): Character {
        return repository.getCharacters().toDomain()
    }
}
