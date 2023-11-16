package com.musicappkt.Screens.PlayListScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicappkt.PlayListItem


@Composable
fun PlayListItem(item: PlayListItem) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = Color.Red),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Default.List,
                contentDescription = "Playlist_Icon",
                tint = Color.White,
            )

            Column(
                Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = item.name, fontSize = 18.sp, color = Color.White
                )

                Icon(
                    modifier = Modifier.size(19.dp),
                    imageVector = Icons.Default.Star,
                    contentDescription = "PlaylistStar_Icon",
                    tint = Color.Yellow,
                )

                Text(text = item.rating.toString(), fontSize = 14.sp, color = Color.White)
            }
        }
    }
}