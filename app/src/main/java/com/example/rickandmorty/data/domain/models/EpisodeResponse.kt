package com.example.rickandmorty.data.domain.models

data class EpisodeResponse(
    val info: PaginationInfo,
    val results: List<Episode>
)


data class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)

