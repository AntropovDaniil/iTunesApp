package com.example.itunesapp

import android.media.AudioAttributes
import android.media.MediaPlayer

object PlayerObject {

    private val mediaPlayerObject: MediaPlayer = MediaPlayer()

    fun getPlayer(): MediaPlayer{
        mediaPlayerObject.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        }
        return mediaPlayerObject
    }

    fun startMedia(){
        mediaPlayerObject.start()
    }

    fun pauseMedia(){
        mediaPlayerObject.pause()
    }



}