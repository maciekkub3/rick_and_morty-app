package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.domain.models.Result
import com.example.rickandmorty.data.network.models.CharacterDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor (
    private val rickAndMortyService: RickAndMortyService
) {

    suspend fun getCharacters(): CharacterDto {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getCharacters()
        }
    }
    suspend fun getCharacterById(id: Int): Result {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getCharacterById(id)
        }
    }


}
