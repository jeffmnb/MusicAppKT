package com.example.musicappkt

data class ArtistSong (
    val imageUrl: String,
    val artistName: String,
    val songTitle: String,
    val songLyrics: String
)

data class PlayListItem(
    val name:String,
    val rating: Number,
    val listenersCount: Number
)