package com.example.itunesapp.presenter

import com.example.itunesapp.ApiClient
import com.example.itunesapp.Post
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.view.AlbumListView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.annotations.NotNull
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumListPresenter() {

    private lateinit var albumListView: AlbumListView
    private lateinit var albumList: List<AlbumModel>

    fun setView(view: AlbumListView){
        albumListView = view
    }

    fun searchAlbums(searchTerm: String){
        val call: Call<Post> = ApiClient.getClient.getTracks(searchTerm)
        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful){
                    albumListView.showError("Code ${response.code()}")
                }
                else{
                    val post: Post? = response.body()
                    val albums = post?.resultModels

                    if (albums != null){
                        albumListView.renderAlbums(albums)
                    }
                    else
                        albumListView.showError("There're no such albums")
                }


            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                albumListView.showError("Failed")
            }
        })
    }
}