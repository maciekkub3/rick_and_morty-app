package com.example.rickandmorty.ui.AppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import com.example.rickandmorty.R
import com.example.rickandmorty.navigation.CharactersRoute

object NavItems
val BottomNavItems = listOf(

    BottomNavItem(
        label = "Characters",
        icon = R.drawable.characters,
        route = CharactersRoute
    ),
    // Search screen
    BottomNavItem(
        label = "Episodes",
        icon = R.drawable.episodes,
        route = CharactersRoute
    ),
    // Profile screen
    BottomNavItem(
        label = "Locations",
        icon = R.drawable.location,
        route = CharactersRoute
    )
)
