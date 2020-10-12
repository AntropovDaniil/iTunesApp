package com.example.itunesapp.ui.viewholder

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_item.view.*

class AlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

    fun setAlbumImage(imageString: String){
        val imageUri: Uri = Uri.parse(imageString)
        Picasso.get().load(imageUri).into(itemView.album_image);
    }

    fun setGenreName(genreName: String){
        itemView.genre_name.text = genreName
    }

    fun setAlbumName(albumName: String){
        itemView.album_name.text = albumName
    }

    fun setArtistName(artistName: String){
        itemView.artist_name.text = artistName
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}