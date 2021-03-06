package com.example.itunesapp.ui.fragment

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.itunesapp.PlayerObject
import com.example.itunesapp.R
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.presenter.MediaPlayerPresenter
import com.example.itunesapp.ui.MediaService
import com.example.itunesapp.ui.activity.AlbumDetailActivity
import com.example.itunesapp.view.MediaPlayerView
import kotlinx.android.synthetic.main.fragment_media_player.*
import kotlinx.android.synthetic.main.fragment_media_player.view.*

class MediaPlayerFragment : Fragment(), MediaPlayerView {

    private lateinit var mediaPlayerPresenter: MediaPlayerPresenter
    private val mediaPlayer = PlayerObject.getPlayer()
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_media_player, container, false)

        mediaPlayerPresenter = MediaPlayerPresenter()
        mediaPlayerPresenter.setView(view)
        PlayerObject.setPresenter(mediaPlayerPresenter)
        //mediaPlayerPresenter.setView(view)

        val mediaService = MediaService::class.java

        val trackModel = arguments?.getParcelable<TrackModel>(AlbumDetailActivity.INTENT_PARAM_TRACK_MODEL)
        if (trackModel != null){
            renderTrackDetails(view, trackModel)
            //mediaPlayerPresenter.setMediaView(view) //TODO переделать
            setListeners(view, mediaService, trackModel)
        }
            else showError("Track Information Not Found")

        seekBar = view.music_player_seekbar
        seekBar.max = 100

        return view
    }

    override fun onStop() {
        super.onStop()
        PlayerObject.stopMedia()
        Log.d("TAG_PLAYER", "Fragment has Stopped")
    }

    override fun renderTrackDetails(view: View, track: TrackModel) {
        mediaPlayerPresenter.setTrackDetails(view, track)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun setListeners(view: View, mediaService: Class<*>, track: TrackModel){
        view.play_button.setOnClickListener {
            val intent = Intent(context, mediaService)
            if (!isServiceRunning(mediaService) && !mediaPlayer.isPlaying) {
                intent.putExtra(MediaService.ACTION_PLAY, track.previewUrl)
                try {
                    context?.startService(intent)
                    Toast.makeText(context, "Service Started", Toast.LENGTH_LONG).show()
                }
                catch (e: Exception){
                    Toast.makeText(context, "Media Error", Toast.LENGTH_LONG).show()
                }
            }
            else if (mediaPlayer.isPlaying){
                //mediaPlayerPresenter.managePlayer()
                    PlayerObject.pauseMedia()
                Toast.makeText(context, "Media Paused", Toast.LENGTH_LONG).show()
            }
            else if (!mediaPlayer.isPlaying){
                //mediaPlayerPresenter.managePlayer()
                    PlayerObject.startMedia()
                Toast.makeText(context, "Media Restarted", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context, "Media Error???", Toast.LENGTH_LONG).show()
            }


        /*
            else if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
                mediaPlayerPresenter.managePlayer(view)
                Toast.makeText(context, "Media Paused", Toast.LENGTH_LONG).show()
            }
            else if (isServiceRunning(mediaService) && !mediaPlayer.isPlaying){
                mediaPlayer.start()
                mediaPlayerPresenter.managePlayer(view)
                Toast.makeText(context, "Media Restarted", Toast.LENGTH_LONG).show()

                //context?.stopService(intent)
            }
            */
        }
    }

    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        // Loop through the running services
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                // If the service is running then return true
                return true
            }
        }
        return false
    }




}