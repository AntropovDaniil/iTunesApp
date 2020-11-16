package com.example.itunesapp.presenter

import android.net.Uri
import android.view.View
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.view.MediaPlayerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.view.*
import kotlinx.android.synthetic.main.fragment_media_player.view.*

class MediaPlayerPresenter {

    private lateinit var mediaPlayerView: MediaPlayerView

    fun setView(view: MediaPlayerView){
        mediaPlayerView = view
    }

    fun setTrackDetails(view: View, track: TrackModel){
        Picasso.get().load(Uri.parse(track.artworkUrl100)).into(view.album_image_track_view)
        view.album_name_track_view.setText("Album - " + track.collectionCensoredName)
        view.track_name_track_view.setText(track.trackCensoredName)
        view.track_name_track_view.isSelected = true
        view.band_name_track_view.setText(track.artistName)
        view.music_time_end.setText(getTimeInMin(track.trackTimeMillis))
    }

    private fun getTimeInMin(trackTime: String): String{
        val timeInMillis = trackTime.toLongOrNull()
        if (timeInMillis == null)
            return "0:00"
        else{
            val sec = timeInMillis/1000%60
            return if (sec>=10) "${timeInMillis/1000/60}:${timeInMillis/1000%60}"
            else "${timeInMillis/1000/60}:0${timeInMillis/1000%60}"
        }
    }
}