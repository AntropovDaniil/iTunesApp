package com.example.itunesapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrackModel(

    @SerializedName("wrapperType")
    @Expose
    private var wrapperType: String,

    @SerializedName("kind")
    @Expose
    private var kind: String,

    @SerializedName("artistId")
    @Expose
    private var artistId: String,

    @SerializedName("collectionId")
    @Expose
    private var collectionId: String,

    @SerializedName("trackId")
    @Expose
    private var trackId: String,

    @SerializedName("artistName")
    @Expose
    private var artistName: String,

    @SerializedName("collectionName")
    @Expose
    private var collectionName: String,

    @SerializedName("trackName")
    @Expose
    var trackName: String,

    @SerializedName("collectionCensoredName")
    @Expose
    private var collectionCensoredName: String,

    @SerializedName("trackCensoredName")
    @Expose
    var trackCensoredName: String,

    @SerializedName("artistViewUrl")
    @Expose
    private var artistViewUrl: String,

    @SerializedName("collectionViewUrl")
    @Expose
    private var collectionViewUrl: String,

    @SerializedName("trackViewUrl")
    @Expose
    private var trackViewUrl: String,

    @SerializedName("previewUrl")
    @Expose
    private var previewUrl: String,

    @SerializedName("artworkUrl100")
    @Expose
    private var artworkUrl100: String,

    @SerializedName("trackTimeMillis")
    @Expose
    val trackTimeMillis:String
    )
{
}