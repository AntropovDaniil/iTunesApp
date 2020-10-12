package com.example.itunesapp.view

import com.example.itunesapp.model.AlbumModel

interface AlbumListView {

    fun renderAlbums(albums: List<AlbumModel>)

    fun showError(errorMessage: String)

    fun openAlbumDetails()
}