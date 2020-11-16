package com.example.itunesapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itunesapp.R
import com.example.itunesapp.fragment.SearchAlbumFragment
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.ui.fragment.MediaPlayerFragment

class MediaPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        val trackModel: TrackModel = intent.getParcelableExtra(AlbumDetailActivity.INTENT_PARAM_TRACK_MODEL)

        initializeActivity(savedInstanceState, trackModel)
    }

    private fun initializeActivity(savedInstanceState: Bundle?, trackModel: TrackModel){
        if(savedInstanceState == null){
            val fragment = MediaPlayerFragment()
            val bundle = Bundle()
            bundle.putParcelable(AlbumDetailActivity.INTENT_PARAM_TRACK_MODEL, trackModel)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .add(R.id.container_media_player, fragment)
                .commit()
        }
    }
}