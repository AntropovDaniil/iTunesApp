package com.example.itunesapp.presenter

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.itunesapp.PlayerObject
import com.example.itunesapp.R
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.view.MediaPlayerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.view.*
import kotlinx.android.synthetic.main.fragment_media_player.view.*

class MediaPlayerPresenter {

    private lateinit var mediaPlayerView: MediaPlayerView
    private lateinit var seekBar: SeekBar
    private lateinit var startTrack: TextView
    private lateinit var endTrack: TextView
    private val handler: Handler = Handler()
    private lateinit var mediaPlayer: MediaPlayer

    fun setView(view: MediaPlayerView){
        mediaPlayerView = view
    }


    fun setTrackDetails(view: View, track: TrackModel){
        Picasso.get().load(Uri.parse(track.artworkUrl100)).into(view.album_image_track_view)
        view.album_name_track_view.setText("Album - ${track.collectionCensoredName}")
        view.track_name_track_view.setText("${track.trackCensoredName} (preview)")
        view.track_name_track_view.isSelected = true
        view.band_name_track_view.setText(track.artistName)
        seekBar = view.music_player_seekbar
        seekBar.max = 100
        startTrack = view.music_time_start
        endTrack = view.music_time_end
    }


    fun managePlayer(view: View){
        mediaPlayer = PlayerObject.getPlayer()
        if (!mediaPlayer.isPlaying){
            view.play_button.setImageResource(R.drawable.ic_baseline_pause_circle)
            mediaPlayer.start()
            updateSeekBar()
            Log.d("TAG_PLAYER", "Presenter managePlayer() method + mediaPlayer is Playing")
        }
        else{
            view.play_button.setImageResource(R.drawable.ic_baseline_play_circle)
            mediaPlayer.pause()
            handler.removeCallbacks(updater)
            Log.d("TAG_PLAYER", "Presenter managePlayer() method + mediaPlayer is not Playing")
            //seekBar.progress = 50
        }
        Log.d("TAG_PLAYER", "Presenter managePlayer() method")
    }

    private val updater: Runnable = Runnable{
        updateSeekBar()
        val currentDuration = mediaPlayer.currentPosition.toLong()
        startTrack.text = getTimeInMin(currentDuration)
        endTrack.text = getTimeInMin(30*1000-currentDuration)
    }


    private fun updateSeekBar(){
        if (mediaPlayer.isPlaying){
            seekBar.progress = ((mediaPlayer.currentPosition.toFloat() / mediaPlayer.duration.toFloat())*100).toInt()
            handler.postDelayed(updater, 1000)
        }
    }

    private fun getTimeInMin(trackTime: Long): String{
        if (trackTime == 0L)
            return "0:00"
        else{
            val sec = trackTime/1000%60
            return if (sec>=10) "${trackTime/1000/60}:${trackTime/1000%60}"
            else "${trackTime/1000/60}:0${trackTime/1000%60}"
        }
    }


}