package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.data.domain.models.Episode
import com.example.rickandmorty.data.domain.models.EpisodeResponse
import com.example.rickandmorty.data.domain.models.LocationResponse
import com.example.rickandmorty.data.network.models.CharacterResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponseDto
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character
    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse
    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Episode
    @GET("location")
    suspend fun getLocations(): LocationResponse
    @GET("character/{ids}")
    suspend fun getMultipleCharactersById(@Path("ids") ids: List<Int>): List<Character>
}