package com.musicappkt.Screens.MusicPlayScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberImagePainter
import com.example.musicappkt.ArtistSong


@Composable
fun ArtistSection(artistSong: ArtistSong, imageScale: Dp) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SubcomposeAsyncImage(
            model = artistSong.imageUrl,
            contentDescription = "image_description",
            contentScale = ContentScale.Crop,
            loading = {
                CircularProgressIndicator(modifier = Modifier.size(40.dp))
            },
            modifier = Modifier
                .size(imageScale)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = artistSong.songTitle,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = artistSong.artistName,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}