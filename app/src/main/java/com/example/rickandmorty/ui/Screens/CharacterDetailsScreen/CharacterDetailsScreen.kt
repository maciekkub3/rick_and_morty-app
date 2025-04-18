package com.example.rickandmorty.ui.Screens.CharacterDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmorty.ui.theme.BackgroundColor
import com.example.rickandmorty.ui.theme.PrimaryColor
import com.example.rickandmorty.ui.theme.SecondaryColor


@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    state: CharacterDetailsViewState,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        if (state.character != null) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = state.character.name,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )
                AsyncImage(
                    model = state.character.image,
                    contentDescription = "Photo of ${state.character.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            shape = RoundedCornerShape(8.dp)
                        )
                )

                Spacer(modifier = Modifier.padding(8.dp))

                InfoField(
                    data = state.character.status,
                    dataType = "Status"
                )
                InfoField(
                    data = state.character.species,
                    dataType = "Species"
                )
                InfoField(
                    data = state.character.gender,
                    dataType = "Gender"
                )
                InfoField(
                    data = state.character.origin.name,
                    dataType = "Origin"
                )
                InfoField(
                    data = state.character.location.name,
                    dataType = "Location"
                )
                InfoField(
                    data = state.character.type,
                    dataType = "Type"
                )
            }
        }
    }
}


@Preview
@Composable
fun InfoFieldPreview(
) {
    InfoField(
        data = "data",
        dataType = "dataType"
    )
}


@Composable
fun InfoField(
    data: String,
    dataType: String,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(SecondaryColor)
            .padding(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
            ) {
                Text(
                    text = "$dataType: ",
                    fontSize = 15.sp,
                    color = Color.White,
                )
            }

            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(PrimaryColor)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = if (data.isEmpty()) "Not defined" else data,
                    fontSize = 15.sp,
                    color = Color.White,
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(4.dp))
}