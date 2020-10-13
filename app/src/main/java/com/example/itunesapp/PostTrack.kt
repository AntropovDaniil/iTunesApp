package com.example.itunesapp

import com.example.itunesapp.model.TrackModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostTrack {

    @SerializedName("resultCount")
    @Expose
    lateinit var resultCount: Integer

    @SerializedName("results")
    @Expose
    lateinit var resultModels: ArrayList<TrackModel>
}