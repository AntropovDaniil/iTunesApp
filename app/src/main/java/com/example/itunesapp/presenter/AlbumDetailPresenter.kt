package com.example.itunesapp.presenter

import android.net.Uri
import android.view.View
import android.widget.Toast
import com.example.itunesapp.ApiClient
import com.example.itunesapp.PostTrack
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.view.AlbumDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AlbumDetailPresenter {

    private lateinit var albumDetailView: AlbumDetailView

    fun setView(view: AlbumDetailView){
        albumDetailView = view
    }

    fun searchTracks(collectionId: String?){
        val call: Call<PostTrack> = ApiClient.getSearchAlbums.getTracks(collectionId)
        call.enqueue(object : Callback<PostTrack> {
            override fun onResponse(call: Call<PostTrack>, response: Response<PostTrack>) {
                if (!response.isSuccessful) {
                    albumDetailView.showError("Code ${response.code()}")
                } else {
                    val post: PostTrack? = response.body()

                    val tracks = post?.resultModels
                    tracks!!.removeAt(0)

                    if (tracks.size != 0) {
                        albumDetailView.renderTracks(tracks)
                    } else
                        albumDetailView.showError("There're no tracks")
                }
            }

            override fun onFailure(call: Call<PostTrack>, t: Throwable) {
                albumDetailView.showError("Failed")
            }
        })
    }

    fun setAlbumDetails(view: View, albumModel: AlbumModel){
        Picasso.get().load(Uri.parse(albumModel.artworkUrl100)).into(view.album_image_detail_view)
        view.album_name_detail_view.text = albumModel.collectionCensoredName
        view.album_name_detail_view.isSelected = true
        view.artist_name_detail_view.text = albumModel.artistName
        val trackCount = "${albumModel.trackCount} tracks"
        view.tracks_amount.text = trackCount

        val trackReleaseDateArray = albumModel.releaseDate.substring(0,10).split("-")
        val trackReleaseDate = "Release: ${trackReleaseDateArray.reversed().joinToString("-")}"
        view.track_release_date.text = trackReleaseDate
    }
}