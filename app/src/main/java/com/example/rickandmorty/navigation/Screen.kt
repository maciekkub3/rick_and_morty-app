package com.example.rickandmorty.navigation

import kotlinx.serialization.Serializable

interface NavRoute {
    val route: String
}

@Serializable
data object CharactersRoute: NavRoute {
    override val route: String = "CharactersRoute"
}

@Serializable
data object EpisodesRoute: NavRoute {
    override val route: String = "EpisodesRoute"
}

@Serializable
data object LocationsRoute: NavRoute {
    override val route: String = "LocationsRoute"
}

@Serializable
data class CharacterDetailsScreenRoute(val characterId: Int): NavRoute {
    override val route: String = "characterDetails/$characterId"
}




