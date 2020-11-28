package com.example.itunesapp.ui

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.itunesapp.PlayerObject
import com.example.itunesapp.R
import kotlinx.android.synthetic.main.fragment_media_player.view.*

//private const val ACTION_PLAY: String = "ACTION_PLAY_CONST"

class MediaService : Service(), MediaPlayer.OnPreparedListener {

    private val handler: Handler = Handler()
    private lateinit var seekBar: SeekBar
    private lateinit var startTrack: TextView
    private lateinit var endTrack: TextView

    companion object{
        val ACTION_PLAY: String = "ACTION_PLAY_CONST"
    }

   private lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val previewUrl = intent?.getStringExtra(ACTION_PLAY)
            mediaPlayer = PlayerObject.getPlayer()
            mediaPlayer.setOnPreparedListener(this@MediaService)
            PlayerObject.setResources(previewUrl)
            Log.d("TAG_PLAYER", "Service onStartCommand")
        }

        return Service.START_STICKY
        //super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onPrepared(mp: MediaPlayer?) {
        PlayerObject.startMedia()
    }

    override fun onDestroy() {
        super.onDestroy()
        //mediaPlayer.pause()
    }

}
