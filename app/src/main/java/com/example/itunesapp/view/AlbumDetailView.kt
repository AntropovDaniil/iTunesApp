package com.example.itunesapp.view

import android.content.Context
import android.view.View
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.model.TrackModel

interface AlbumDetailView {

    fun renderAlbumDetails(view: View, album: AlbumModel)

    fun renderTracks(trackList: List<TrackModel>)

    fun showError(errorMessage: String)

}