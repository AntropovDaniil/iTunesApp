package com.example.itunesapp.ui.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.R
import com.example.itunesapp.activity.SearchAlbumActivity
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.presenter.AlbumListPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class AlbumListAdapter(val context: Context?,
                       val albumListPresenter: AlbumListPresenter,
                       val onClickListener: OnAlbumClickListener): RecyclerView.Adapter<AlbumListAdapter.AlbumListViewHolder>() {

    private val albumList = ArrayList<AlbumModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false)
        return AlbumListViewHolder(view)
    }

    override fun onBindViewHolder(holderList: AlbumListViewHolder, position: Int) {
        val album: AlbumModel = albumList[position]
        holderList.setAlbumImage(album.artworkUrl100)
        holderList.setAlbumName(album.collectionCensoredName)
        holderList.setArtistName(album.artistName)
        holderList.setGenreName(album.primaryGenreName)
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

    interface OnAlbumClickListener{
        fun onAlbumClick(album: AlbumModel)
    }

    inner class AlbumListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init{
            itemView.setOnClickListener {
                val albumModel = albumList[adapterPosition]
                onClickListener.onAlbumClick(albumModel)
            }
        }

        fun setAlbumImage(imageString: String){
            val imageUri: Uri = Uri.parse(imageString)
            Picasso.get().load(imageUri).into(itemView.album_image)
        }

        fun setGenreName(genreName: String){
            itemView.genre_name.text = genreName
        }

        fun setAlbumName(albumName: String){
            itemView.album_name.text = albumName
            itemView.album_name.isSelected = true
        }

        fun setArtistName(artistName: String){
            itemView.artist_name.text = artistName
        }
    }
}