package com.example.itunesapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import com.example.itunesapp.R
import com.example.itunesapp.fragment.SearchAlbumFragment
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.ui.activity.AlbumDetailActivity

class SearchAlbumActivity : AppCompatActivity() {

    companion object{
        var INTENT_PARAM_ALBUM_MODEL: String = "INTENT_PARAM_ALBUM_MODEL"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_album)

        initializeActivity(savedInstanceState)
    }

    private fun initializeActivity(@Nullable savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                                    .add(R.id.container_album_search, SearchAlbumFragment())
                                    .commit()
        }
    }

    fun navigateToAlbumDetails(albumModel: AlbumModel){
        val intent = Intent(this, AlbumDetailActivity::class.java)
        intent.putExtra(INTENT_PARAM_ALBUM_MODEL, albumModel)
        this.startActivity(intent)
    }

}