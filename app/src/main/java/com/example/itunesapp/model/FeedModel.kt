package com.example.itunesapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Class of entity that is a parent for top albums in ITunes
 */
data class FeedModel(
    @SerializedName("results")
    @Expose
    var albumResults: ArrayList<TopAlbumModel>) {
}