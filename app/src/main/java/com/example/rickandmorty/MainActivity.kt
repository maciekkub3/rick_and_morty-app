package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.navigation.Navigation
import com.example.rickandmorty.ui.AppBar.BottomNavigationBar
import androidx.compose.runtime.getValue
import com.example.rickandmorty.navigation.CharactersRoute
import com.example.rickandmorty.navigation.EpisodesRoute
import com.example.rickandmorty.navigation.LocationsRoute

import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

val bottomNavRoutes = listOf(
    CharactersRoute,
    EpisodesRoute,
    LocationsRoute
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route?.substringAfterLast(".")
            val showBottomBar = currentRoute in bottomNavRoutes.map { it.route }

            WindowCompat.setDecorFitsSystemWindows(window, false)
            RickAndMortyTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),

                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigationBar(
                                onCharactersClick = {
                                    navController.navigate(CharactersRoute) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                },
                                onEpisodesClick = {
                                    navController.navigate(EpisodesRoute) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                },
                                onLocationClick = {
                                    navController.navigate(LocationsRoute) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}

