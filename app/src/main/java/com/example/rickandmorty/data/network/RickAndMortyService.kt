package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.domain.models.Result
import com.example.rickandmorty.data.network.models.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharacters(): CharacterDto
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Result

}