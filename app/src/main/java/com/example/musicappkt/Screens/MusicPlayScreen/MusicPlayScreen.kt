package com.example.musicappkt.Screens.MusicPlayScreen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.musicappkt.Components.ArtistSection
import com.example.musicappkt.Components.MenuBar
import com.example.musicappkt.Components.SongMenu
import com.example.musicappkt.Services.artistSongList

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun MusicPlayScreen() {

    var isPlaying by remember {
        mutableStateOf<Boolean>(false)
    }

    var isForwarding by remember {
        mutableStateOf<Boolean>(false)
    }

    var selectedIndex by remember { mutableStateOf<Int>(0) }

    val gradientColors = listOf(
        Color(0xFF01234A), Color(0xFF673AB7)
    )

    fun handleBackSongMenu() {
        isForwarding = false
        if (selectedIndex == 0) {
            selectedIndex = artistSongList.size - 1
        } else selectedIndex--
    }

    fun handlePlaySongMenu() {
        isForwarding = false
        isPlaying = !isPlaying
    }

    fun handleForwardSongMenu() {
        isForwarding = true
        if (selectedIndex == artistSongList.size - 1) {
            selectedIndex = 0
        } else selectedIndex++
    }




    Column(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(gradientColors))
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MenuBar()

        Spacer(Modifier.height(16.dp))


        AnimatedContent(targetState = selectedIndex, transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { if (isForwarding) 1000 else -1000 }, animationSpec = tween(500)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { if (isForwarding) -1000 else 1000 },
                animationSpec = tween(durationMillis = 500)
            )
        }, label = "") {
            ArtistSection(artistSong = artistSongList[selectedIndex])
        }



        Spacer(Modifier.height(32.dp))

        SongMenu(isPlaying,
            onBackClick = { handleBackSongMenu() },
            onPLayPauseClick = { handlePlaySongMenu() },
            onForwardClick = { handleForwardSongMenu() })
    }

}