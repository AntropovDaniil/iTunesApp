package com.example.itunesapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultModel {

    @SerializedName("artistId")
    @Expose
    lateinit var artistId: String

    @SerializedName("collectionName")
    @Expose
    lateinit var collectionName: String

    @SerializedName("artistName")
    @Expose
    lateinit var artistName: String

    @SerializedName("primaryGenreName")
    @Expose
    lateinit var primaryGenreName: String
}