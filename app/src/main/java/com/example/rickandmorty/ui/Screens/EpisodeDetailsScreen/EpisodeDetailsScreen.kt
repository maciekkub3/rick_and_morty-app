package com.example.rickandmorty.ui.Screens.EpisodeDetailsScreen

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickandmorty.data.domain.models.Character
import com.example.rickandmorty.ui.theme.BackgroundColor
import com.example.rickandmorty.ui.theme.PrimaryColor

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    state: EpisodeDetailsViewState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        if (state.episode != null) {

            Text(
                text = "Episode Name: ${state.episode.name}",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Air Date: ${state.episode.air_date}",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Characters:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            CharactersList(
                characters = state.characters,
            )

        } else if (state.isLoading) {
            // Show loading indicator
            CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
        } else if (state.error != null) {
            // Show error message
            Text(text = "Error: ${state.error}", color = Color.Red)
        }
    }
}


@Composable
fun CharactersList(
    characters: List<Character>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(characters.size) { index ->
            val character = characters[index]
            CharacterItem(character = character)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(PrimaryColor)
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(CenterVertically)
        ) {
            Text(
                text = character.name,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = "Species: ${character.species}",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }

}