package com.musicappkt.Screens.PlayListScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlaylistPlay
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
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
fun PlayListItem(item: PlayListItem, onClickItem: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickItem },
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(38.dp),
                imageVector = Icons.Default.PlaylistPlay,
                contentDescription = "PlaylistPlay_Icon",
                tint = Color.White,
            )

            Column(
                Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = item.name, fontSize = 20.sp, color = Color.White
                )

                Row(
                    Modifier.padding(top = 7.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(17.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "PlaylistStar_Icon",
                        tint = Color.Yellow,
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = item.rating.toString(), fontSize = 13.sp, color = Color.White)



                    Spacer(modifier = Modifier.width(12.dp))



                    Icon(
                        modifier = Modifier.size(17.dp),
                        imageVector = Icons.Default.Headphones,
                        contentDescription = "PlaylistStaHeadPhones_Icon",
                        tint = Color.Yellow,
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = item.listenersCount.toString(), fontSize = 13.sp, color = Color.White
                    )
                }
            }
        }

        Divider(Modifier.fillMaxWidth(), color = Color.Gray)
    }
}