package com.example.musicappkt.Components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicappkt.Components.ui.theme.MusicAppKTTheme

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