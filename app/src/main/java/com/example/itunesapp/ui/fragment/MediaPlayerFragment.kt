package com.example.itunesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.itunesapp.R
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.presenter.MediaPlayerPresenter
import com.example.itunesapp.ui.activity.AlbumDetailActivity
import com.example.itunesapp.view.MediaPlayerView

class MediaPlayerFragment : Fragment(), MediaPlayerView {

    lateinit var mediaPlayerPresenter: MediaPlayerPresenter

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
        mediaPlayerPresenter.setView(this)

        val trackModel = arguments?.getParcelable<TrackModel>(AlbumDetailActivity.INTENT_PARAM_TRACK_MODEL)
        if (trackModel != null){
            renderTrackDetails(view, trackModel)
        }
            else showError("Track Information Not Found")

        return view
    }

    override fun renderTrackDetails(view: View, track: TrackModel) {
        mediaPlayerPresenter.setTrackDetails(view, track)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

}