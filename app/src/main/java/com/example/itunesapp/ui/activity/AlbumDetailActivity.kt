package com.example.itunesapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itunesapp.R
import com.example.itunesapp.activity.SearchAlbumActivity
import com.example.itunesapp.fragment.SearchAlbumFragment
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.ui.fragment.AlbumDetailFragment

class AlbumDetailActivity : AppCompatActivity() {

    companion object{
        var INTENT_PARAM_TRACK_MODEL: String = "INTENT_PARAM_TRACK_MODEL"
        //var SAVED_PARAM_TRACK_MODEL: String = "SAVED_PARAM_TRACK_MODEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail)

        val albumModel: AlbumModel = intent.getParcelableExtra(SearchAlbumActivity.INTENT_PARAM_ALBUM_MODEL)

        initializeActivity(savedInstanceState, albumModel)
    }

    private fun initializeActivity(savedInstanceState: Bundle?, albumModel: AlbumModel){
        if(savedInstanceState == null){
            val fragment = AlbumDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(SearchAlbumActivity.INTENT_PARAM_ALBUM_MODEL, albumModel)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .add(R.id.container_album_detail, fragment)
                .commit()
        }
    }

    fun navigateToMediaPlayer(trackModel: TrackModel){
        val intent = Intent(this, MediaPlayerActivity::class.java)
        intent.putExtra(INTENT_PARAM_TRACK_MODEL, trackModel)
        this.startActivity(intent)
    }
}