package com.example.itunesapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FeedModel(
    @SerializedName("results")
    @Expose
    var albumResults: ArrayList<AlbumModel>) {
}