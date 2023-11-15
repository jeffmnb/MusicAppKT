package com.musicappkt.Screens.MusicPlayScreen.Components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LyricsSection(lyric: String, scrollState: ScrollState) {
    Text(
        text = lyric,
        style = MaterialTheme.typography.headlineLarge,
        color = Color.White,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    )
}