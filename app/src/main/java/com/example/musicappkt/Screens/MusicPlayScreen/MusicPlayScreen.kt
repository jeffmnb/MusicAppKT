package com.example.musicappkt.Screens.MusicPlayScreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicappkt.ArtistSong
import com.example.musicappkt.Components.ArtistSection
import com.example.musicappkt.Components.MenuBar
import com.example.musicappkt.Components.SongMenu
import com.example.musicappkt.ui.theme.MusicAppKTTheme
import java.time.format.TextStyle

@Composable
fun MusicPlayScreen() {

    var isPlaying by remember {
        mutableStateOf<Boolean>(false)
    }

    var selectedIndex by remember { mutableStateOf<Int>(0) }

    val artistSongList = listOf<ArtistSong>(
        ArtistSong(
            imageUrl = "https://images.pexels.com/photos/1714354/pexels-photo-1714354.jpeg",
            artistName = "Jeff Borda",
            songTitle = "Love Story",
            songLyrics = "ASjdbh8y7qew3gdfabs9g as9g d7ew9gd7e86wg f7wgdbew8 fg 87wgf 9wg78w9egf 7wefg wefewhf w e87g fwe8f we8f hgwebfgwe"
        ), ArtistSong(
            imageUrl = "https://images.pexels.com/photos/3693108/pexels-photo-3693108.jpeg",
            artistName = "Rocking in the Free World",
            songTitle = "John Smith",
            songLyrics = "Asdhg8asydibaisdg asiudgta8b s7gt diuyasgd8a 6srtd8as gd8asrt d8asg dast7 dra7isdg8asdgfaisydfg6as78fdgasid"
        ), ArtistSong(
            imageUrl = "https://images.pexels.com/photos/4406759/pexels-photo-4406759.jpeg",
            artistName = "Daniel Johnson",
            songTitle = "Smooth Jazz Groove",
            songLyrics = "ASdfweraysudgvasjhd asygda 8s7y6dfgaysiudgfv67wq vdsayiudf 67 asvd7 6asvda 6s7dfgvqw6dfgas8dgfas6 fdga8s6dfas678d"
        )
    )


    val gradientColors = listOf(
        Color(0xFF01234A), Color(0xFF673AB7)
    )

    Column(
        Modifier
            .background(brush = Brush.verticalGradient(gradientColors))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MenuBar()

        Spacer(Modifier.height(16.dp))

        ArtistSection(artistSong = artistSongList[selectedIndex])


        Spacer(Modifier.height(32.dp))

        SongMenu(isPlaying, onBackClick = {
            if (selectedIndex == 0) {
                Log.d("", "é zero")
                selectedIndex = artistSongList.size - 1
            } else
            Log.d("", "tirando um")
            selectedIndex--
        }, onPLayPauseClick = { isPlaying = !isPlaying }, onForwardClick = {
            if (selectedIndex == artistSongList.size - 1) {
                Log.d("", "é o ultimo")
                selectedIndex = 0
            } else
            selectedIndex++
            Log.d("", "colocando um")

        })
    }

}