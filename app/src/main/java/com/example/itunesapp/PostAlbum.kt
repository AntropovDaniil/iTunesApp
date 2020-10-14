package com.example.itunesapp

import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.model.FeedModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostAlbum {

    @SerializedName("results")
    @Expose
    lateinit var resultModels: ArrayList<AlbumModel>

    @SerializedName("feed")
    @Expose
    lateinit var topAlbumResultModel: FeedModel
}