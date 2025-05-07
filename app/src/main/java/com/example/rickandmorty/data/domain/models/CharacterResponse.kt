package com.example.rickandmorty.data.domain.models

data class CharacterResponse(
    val info: PaginationInfo,
    val results: List<Character>
)

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)