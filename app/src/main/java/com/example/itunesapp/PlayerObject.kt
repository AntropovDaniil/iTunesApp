package com.example.itunesapp

import android.media.AudioAttributes
import android.media.MediaPlayer
import com.example.itunesapp.presenter.MediaPlayerPresenter

object PlayerObject {

    private val mediaPlayerObject: MediaPlayer = MediaPlayer()
    private lateinit var mediaPlayerPresenter: MediaPlayerPresenter

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

    fun setResources(previewUrl: String){
        mediaPlayerObject.setDataSource(previewUrl)
        mediaPlayerObject.prepareAsync()
    }

    fun setPresenter(mediaPresenter: MediaPlayerPresenter){
        mediaPlayerPresenter = mediaPresenter
    }

    fun startMedia(){
        mediaPlayerObject.start()
        mediaPlayerPresenter.managePlayer()
    }

    fun pauseMedia(){
        mediaPlayerObject.pause()
        mediaPlayerPresenter.managePlayer()
    }

    fun stopMedia(){
        mediaPlayerObject.stop()
    }



}