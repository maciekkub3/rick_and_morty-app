package com.example.rickandmorty.data.network.models

data class CharacterDto(
    val info: InfoDto,
    val results: List<ResultDto>
)

data class InfoDto(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: Any?
)

data class ResultDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationDto(
    val name: String,
    val url: String
)

data class OriginDto(
    val name: String,
    val url: String
)