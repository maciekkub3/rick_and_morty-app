package com.example.rickandmorty.ui.AppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmorty.ui.theme.onSecondaryColor

@Preview
@Composable
fun BottomAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(onSecondaryColor)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Characters",
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "Locations",
            tint = Color.White
        )

        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Episodes",
            tint = Color.White
        )
    }
}