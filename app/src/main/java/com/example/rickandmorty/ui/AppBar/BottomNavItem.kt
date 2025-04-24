package com.example.rickandmorty.ui.AppBar

import com.example.rickandmorty.navigation.NavRoute

data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: NavRoute
)