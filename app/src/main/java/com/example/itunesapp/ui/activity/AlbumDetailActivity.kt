package com.example.itunesapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itunesapp.R
import com.example.itunesapp.activity.SearchAlbumActivity
import com.example.itunesapp.fragment.SearchAlbumFragment
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.ui.fragment.AlbumDetailFragment

class AlbumDetailActivity : AppCompatActivity() {
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
}