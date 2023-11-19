package com.example.musicappkt.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.musicappkt.Screens.MusicPlayScreen.MusicPlayScreen
import com.musicappkt.Screens.PlayListScreen.PlayListScreen

@Composable
fun NavigateService(){

    val navControler = rememberNavController()

    NavHost(navController = navControler, startDestination = "MusicPlayScreen"){

        composable("MusicPlayScreen") {
            MusicPlayScreen(navControler)
        }

        composable("PlayListScreen"){
            PlayListScreen(navControler)
        }
    }
}