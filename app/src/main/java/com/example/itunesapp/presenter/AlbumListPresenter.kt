package com.example.itunesapp.presenter

import com.example.itunesapp.ApiClient
import com.example.itunesapp.PostAlbum
import com.example.itunesapp.view.AlbumListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumListPresenter() {

    private lateinit var albumListView: AlbumListView
    //private lateinit var albumList: List<AlbumModel>

    fun setView(view: AlbumListView){
        albumListView = view
    }

    fun searchAlbums(searchTerm: String){
        val call: Call<PostAlbum> = ApiClient.getClient.getAlbums(searchTerm)
        call.enqueue(object : Callback<PostAlbum> {
            override fun onResponse(call: Call<PostAlbum>, response: Response<PostAlbum>) {
                if (!response.isSuccessful){
                    albumListView.showError("Code ${response.code()}")
                }
                else{
                    val post: PostAlbum? = response.body()
                    val albums = post?.resultModels

                    if (albums != null){
                        albumListView.renderAlbums(albums)
                    }
                    else
                        albumListView.showError("There're no such albums")
                }
            }

            override fun onFailure(call: Call<PostAlbum>, t: Throwable) {
                albumListView.showError("Failed")
            }
        })
    }


}