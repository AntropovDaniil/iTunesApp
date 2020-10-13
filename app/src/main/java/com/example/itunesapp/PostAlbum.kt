package com.example.itunesapp

import com.example.itunesapp.model.AlbumModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostAlbum {

    @SerializedName("resultCount")
    @Expose
    lateinit var resultCount: Integer

    @SerializedName("results")
    @Expose
    lateinit var resultModels: List<AlbumModel>
}