package com.example.rickandmorty.ui.Screens.LocationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.ui.theme.BackgroundColor
import com.example.rickandmorty.ui.theme.PrimaryColor

@Composable
fun LocationScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    state: LocationViewState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp)
    ){
        Text(
            text = "Locations",
            fontSize = 42.sp,
            color = PrimaryColor,
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}