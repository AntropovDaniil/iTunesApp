package com.example.itunesapp.view

import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.model.TopAlbumModel

interface AlbumListView {

    fun renderTopAlbums(albums: List<TopAlbumModel>)

    fun renderAlbums(albums: List<AlbumModel>)

    fun showError(errorMessage: String)

}