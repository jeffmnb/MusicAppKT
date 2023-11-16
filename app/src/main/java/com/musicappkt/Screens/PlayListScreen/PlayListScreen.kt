package com.musicappkt.Screens.PlayListScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicappkt.Services.playListItemData
import com.musicappkt.Screens.PlayListScreen.Components.HeaderPlayList
import com.musicappkt.Screens.PlayListScreen.Components.PlayListItem


@Composable
fun PlayListScreen(navigation: NavController) {
    val playlistData = playListItemData

    val gradientColors = listOf(
        Color(0xFF010311), Color(0xFF0E125A)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(gradientColors))
            .padding(top = 26.dp, end = 16.dp, start = 16.dp)
    ) {
        HeaderPlayList()

        LazyColumn(
            Modifier.padding(top = 20.dp)
        ) {
            items(playlistData) { item ->
                PlayListItem(item)
            }
        }

    }
}