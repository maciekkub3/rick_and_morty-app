package com.example.rickandmorty.navigation

import kotlinx.serialization.Serializable

@Serializable
data object MainRoute

@Serializable
data class CharacterDetailsScreenRoute(val characterId: Int)




