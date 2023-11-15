package com.musicappkt.Screens.MusicPlayScreen.Components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MenuBar(onClickListMenu: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Music Player", fontWeight = FontWeight.Bold, color = Color.White)
        IconButton(onClick = { onClickListMenu() }) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "Playlist_Icon_Menu",
                tint = Color.White,
            )
        }
    }
}