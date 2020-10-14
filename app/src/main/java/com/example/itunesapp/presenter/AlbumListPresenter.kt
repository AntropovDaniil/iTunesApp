package com.example.itunesapp.presenter

import com.example.itunesapp.ApiClient
import com.example.itunesapp.PostAlbum
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.view.AlbumListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumListPresenter() {

    private lateinit var albumListView: AlbumListView

    fun setView(view: AlbumListView){
        albumListView = view
    }

    fun searchAlbums(searchTerm: String){
        val call: Call<PostAlbum> = ApiClient.getSearchAlbums.getAlbums(searchTerm)
        call.enqueue(object : Callback<PostAlbum> {
            override fun onResponse(call: Call<PostAlbum>, response: Response<PostAlbum>) {
                if (!response.isSuccessful){
                    albumListView.showError("Code ${response.code()}")
                }
                else{
                    val post: PostAlbum? = response.body()
                    val albums = post?.resultModels
                    albums!!.removeAt(0)

                    if (albums.size != 0){
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

    /*fun showTopAlbums(){
        val call: Call<PostAlbum> = ApiClient.getTopAlbums.getTopAlbums()
        call.enqueue(object : Callback<PostAlbum> {
            override fun onResponse(call: Call<PostAlbum>, response: Response<PostAlbum>) {
                if (!response.isSuccessful) {
                    albumListView.showError("Code ${response.code()}")
                } else {
                    val post: PostAlbum? = response.body()
                    val feed = post?.topAlbumResultModel
                    println("FEED!!! ${feed.toString()}")
                    if (feed != null) {
                        albumListView.renderAlbums(feed.albumResults)
                    } else
                        albumListView.showError("There're no such albums")
                }
            }

            override fun onFailure(call: Call<PostAlbum>, t: Throwable) {
                albumListView.showError("Failed")
                println("FAILED $t")
            }
        })
    }*/


}