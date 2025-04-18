package com.example.rickandmorty.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.rickandmorty.ui.Screens.CharacterDetailsScreen.CharacterDetailsScreen
import com.example.rickandmorty.ui.Screens.CharacterDetailsScreen.CharacterDetailsViewModel
import com.example.rickandmorty.ui.Screens.MainScreen.MainScreen
import androidx.compose.runtime.getValue
import com.example.rickandmorty.ui.Screens.MainScreen.MainScreenViewModel


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute
    ) {
        composable<MainRoute> {
            val viewModel: MainScreenViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            MainScreen(navController = navController, state = state)
        }
        composable<CharacterDetailsScreenRoute> {
            val viewModel: CharacterDetailsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            CharacterDetailsScreen(navController = navController, state = state)

        }

    }
}