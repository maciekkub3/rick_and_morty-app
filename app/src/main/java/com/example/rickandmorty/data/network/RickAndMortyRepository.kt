package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.domain.models.Episode
import com.example.rickandmorty.data.domain.models.EpisodeResponse
import com.example.rickandmorty.data.domain.models.LocationResponse
import com.example.rickandmorty.data.network.models.CharacterResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor (
    private val rickAndMortyService: RickAndMortyService
) {


    suspend fun getCharacters(): CharacterResponseDto {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getCharacters()
        }
    }
    suspend fun getCharacterById(id: Int): Character {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getCharacterById(id)
        }
    }
    suspend fun getEpisodes(): EpisodeResponse {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getEpisodes()
        }
    }
    suspend fun getEpisodeById(id: Int): Episode {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getEpisodeById(id)
        }
    }
    suspend fun getLocations(): LocationResponse {
        return withContext(Dispatchers.IO) {
            rickAndMortyService.getLocations()
        }
    }
}
