package com.example.itunesapp.ui

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

//private const val ACTION_PLAY: String = "ACTION_PLAY_CONST"

class MediaService : Service(), MediaPlayer.OnPreparedListener {

    companion object{
        val ACTION_PLAY: String = "ACTION_PLAY_CONST"
    }

    private lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val previewUrl = intent?.getStringExtra(ACTION_PLAY)
            /*val action: String? = intent?.action
            when (action) {
                ACTION_PLAY -> {
                    mediaPlayer = MediaPlayer()
                    mediaPlayer.apply {
                        setAudioAttributes(
                            AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                        )
                        setOnPreparedListener(this@MediaService)
                        setDataSource(previewUrl)
                        prepareAsync()
                        start()
                    }
                    Log.e("TAG", "ACTION_PLAY")
                }
            }*/
            mediaPlayer = MediaPlayer()
            mediaPlayer.apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setOnPreparedListener(this@MediaService)
                setDataSource(previewUrl)
                prepareAsync()
                start()
            }


        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start()
    }
}
