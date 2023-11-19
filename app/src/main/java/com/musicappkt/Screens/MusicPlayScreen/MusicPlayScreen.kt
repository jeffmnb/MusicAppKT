package com.musicappkt.Screens.MusicPlayScreen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.musicappkt.Services.artistSongList
import com.musicappkt.Screens.MusicPlayScreen.Components.ArtistSection
import com.musicappkt.Screens.MusicPlayScreen.Components.LyricsSection
import com.musicappkt.Screens.MusicPlayScreen.Components.MenuBar
import com.musicappkt.Screens.MusicPlayScreen.Components.SongMenu

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun MusicPlayScreen(navigation: NavController) {

    var isPlaying by remember {
        mutableStateOf<Boolean>(false)
    }

    var isForwarding by remember {
        mutableStateOf<Boolean>(false)
    }

    var scrollState = rememberScrollState()

    val imageScale by animateDpAsState(targetValue = if (scrollState.value > 0) 160.dp else 240.dp)

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
        MenuBar(onClickListMenu = { navigation.navigate("PlayListScreen") })

        Spacer(Modifier.height(16.dp))

        AnimatedContent(targetState = selectedIndex, transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { if (isForwarding) 1000 else -1000 }, animationSpec = tween(500)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { if (isForwarding) -1000 else 1000 },
                animationSpec = tween(durationMillis = 500)
            )
        }, label = "") {
            ArtistSection(artistSong = artistSongList[selectedIndex], imageScale = imageScale)
        }

        Spacer(Modifier.height(32.dp))

        SongMenu(isPlaying,
            onBackClick = { handleBackSongMenu() },
            onPLayPauseClick = { handlePlaySongMenu() },
            onForwardClick = { handleForwardSongMenu() })

        LyricsSection(artistSongList[selectedIndex].songLyrics, scrollState)
    }

}