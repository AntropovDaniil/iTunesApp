package com.example.itunesapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultModel {

    @SerializedName("image")
    @Expose
    lateinit var image: String

    @SerializedName("collectionName")
    @Expose
    lateinit var collectionName: String

    @SerializedName("artistName")
    @Expose
    lateinit var artistName: String

    @SerializedName("trackName")
    @Expose
    lateinit var trackName: String
}