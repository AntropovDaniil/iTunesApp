package com.example.itunesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.R
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.presenter.AlbumListPresenter
import com.example.itunesapp.ui.viewholder.AlbumViewHolder
import java.util.*
import kotlin.collections.ArrayList

class AlbumAdapter(val context: Context?, val albumListPresenter: AlbumListPresenter): RecyclerView.Adapter<AlbumViewHolder>() {

    private val albumList = ArrayList<AlbumModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album: AlbumModel = albumList[position]
        holder.setAlbumImage(album.artworkUrl100)
        holder.setAlbumName(album.collectionCensoredName)
        holder.setArtistName(album.artistName)
        holder.setGenreName(album.primaryGenreName)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    fun setAlbums(albums: List<AlbumModel>){
        albumList.clear()
        Collections.sort(albums)
        albumList.addAll(albums)

        notifyDataSetChanged()
    }

}