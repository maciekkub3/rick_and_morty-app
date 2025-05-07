package com.example.rickandmorty.ui.Screens.EpisodeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.data.domain.models.Episode
import com.example.rickandmorty.ui.theme.BackgroundColor
import com.example.rickandmorty.ui.theme.PrimaryColor

@Composable
fun EpisodeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    state: EpisodeViewState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp)
    ) {
        Text(
            text = "Episodes",
            fontSize = 42.sp,
            color = PrimaryColor,
            modifier = Modifier.align(CenterHorizontally),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(5.dp))

        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }

            state.error != null -> {
                Text(text = "Error: ${state.error}", color = Color.Red)
            }

            else -> {
                EpisodeList(
                    episodes = state.episodes,
                    onEpisodeClick = {}
                )
            }
        }
    }
}

@Composable
fun EpisodeList(
    episodes: List<Episode>,
    onEpisodeClick: (Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(episodes.size) { index ->
            val episode = episodes[index]
            EpisodeCard(episode = episode, onEpisodeClick = onEpisodeClick)
        }
    }
}

@Composable
fun EpisodeCard(
    episode: Episode,
    onEpisodeClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, PrimaryColor, shape = RoundedCornerShape(8.dp))
            .clickable {
                onEpisodeClick(episode.id)
            }
    ) {
        Text(
            text = "Episode ${episode.episode}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = episode.name,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Added on ${episode.air_date}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )
    }

}


//@Preview
//@Composable
//fun EpisodeCardPreview() {
//    EpisodeCard(episode = episode, onEpisodeClick = {})
//}

