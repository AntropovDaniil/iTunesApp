package com.example.itunesapp.view

import android.view.View
import com.example.itunesapp.model.TrackModel

interface MediaPlayerView {

    fun renderTrackDetails(view: View, track: TrackModel)

    fun showError(errorMessage: String)
}