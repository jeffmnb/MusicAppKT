package com.musicappkt.Screens.MusicPlayScreen.Components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SongMenu(
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onForwardClick: () -> Unit,
    onPLayPauseClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "arrowBackIcon",
                    tint = Color.White
                )
            }

            IconButton(onClick = { onPLayPauseClick() }) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.PlayArrow else Icons.Default.Close,
                    contentDescription = "playPauseIcon",
                    tint = Color.White
                )
            }

            IconButton(onClick = onForwardClick) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "arrowForwardIcon",
                    tint = Color.White
                )
            }
        }
    }
}