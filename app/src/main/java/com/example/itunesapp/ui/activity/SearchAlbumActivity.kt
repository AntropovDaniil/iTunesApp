package com.example.itunesapp.activity

import android.app.FragmentTransaction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.fragment.app.FragmentManager
import com.example.itunesapp.R
import com.example.itunesapp.fragment.SearchAlbumFragment

class SearchAlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_album)

        initializeActivity(savedInstanceState)
    }

    fun initializeActivity(@Nullable savedInstanceState: Bundle?){
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                                    .add(R.id.container, SearchAlbumFragment())
                                    .commit()
        }
    }
}