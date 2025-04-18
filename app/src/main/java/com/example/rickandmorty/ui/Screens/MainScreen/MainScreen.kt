package com.example.rickandmorty.ui.Screens.MainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickandmorty.data.domain.models.Result
import com.example.rickandmorty.R
import com.example.rickandmorty.navigation.CharacterDetailsScreenRoute
import com.example.rickandmorty.ui.theme.BackgroundColor
import com.example.rickandmorty.ui.theme.PrimaryColor
import com.example.rickandmorty.ui.theme.onPrimaryColor
import com.example.rickandmorty.ui.theme.onSecondaryColor

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    state: MainViewState
) {

    Column(
        modifier = modifier
            .fillMaxSize()

            .background(BackgroundColor)
            .padding(16.dp)

    ) {

        Text(
            text = "Rick and Morty",
            fontSize = 42.sp,
            color = PrimaryColor,
            modifier = Modifier.align(CenterHorizontally),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(5.dp))


        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search characters", color = Color.White) },
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedContainerColor = onPrimaryColor,
                focusedContainerColor = onSecondaryColor
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(10.dp))

        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }

            state.error != null -> {
                Text(text = "Error: ${state.error}", color = Color.Red)
            }

            else -> {
                CharacterList(
                    characters = state.characters,
                    onCharacterClick = { characterId ->
                        navController.navigate(CharacterDetailsScreenRoute(characterId = characterId))
                    }
                )
            }
        }
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun CharacterList(
    characters: List<Result>,
    onCharacterClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ) {
        items(characters.size) { index ->
            val character = characters[index]
            Box(
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .shadow(4.dp, RoundedCornerShape(8.dp))
                        .clickable {
                            onCharacterClick(character.id)
                        }
                ) {

                    Column(
                        modifier = Modifier
                            .background(PrimaryColor)
                    ) {
                        AsyncImage(
                            model = character.image,
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = "Photo of ${character.name}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 5.dp)
                                .padding(top = 5.dp)
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,

                            )
                        Text(
                            text = character.name,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(start = 5.dp)


                        )

                        val statusColor = when (character.status) {
                            "Alive" -> Color.Green
                            "Dead" -> Color.Red
                            else -> Color.Yellow
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(statusColor)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${character.status} - ${character.species}",
                                color = Color.White,
                                fontSize = 13.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}


