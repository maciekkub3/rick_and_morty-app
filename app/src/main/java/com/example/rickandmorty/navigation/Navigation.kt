package com.example.rickandmorty.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.ui.Screens.CharacterDetailsScreen.CharacterDetailsScreen
import com.example.rickandmorty.ui.Screens.CharacterDetailsScreen.CharacterDetailsViewModel
import com.example.rickandmorty.ui.Screens.CharacterScreen.MainScreen
import androidx.compose.runtime.getValue
import com.example.rickandmorty.ui.Screens.CharacterScreen.CharacterScreenViewModel
import com.example.rickandmorty.ui.Screens.EpisodeScreen.EpisodeScreen
import com.example.rickandmorty.ui.Screens.EpisodeScreen.EpisodeScreenViewModel
import com.example.rickandmorty.ui.Screens.LocationScreen.LocationScreen
import com.example.rickandmorty.ui.Screens.LocationScreen.LocationScreenViewModel


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CharactersRoute
    ) {

        composable<CharactersRoute> {
            val viewModel: CharacterScreenViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            MainScreen(navController = navController, state = state)
        }
        composable<CharacterDetailsScreenRoute> {
            val viewModel: CharacterDetailsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            CharacterDetailsScreen(navController = navController, state = state)
        }
        composable<EpisodesRoute> {
            val viewModel: EpisodeScreenViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            EpisodeScreen(navController = navController, state = state)
        }
        composable<LocationsRoute> {
            val viewModel: LocationScreenViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            LocationScreen(navController = navController, state = state)
        }

    }
}