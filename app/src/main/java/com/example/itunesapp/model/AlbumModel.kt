package com.example.itunesapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumModel(

    @SerializedName("collectionType")
    @Expose
    private var collectionType: String,

    @SerializedName("artistId")
    @Expose
    private var artistId: String,

    @SerializedName("artistName")
    @Expose
    var artistName: String,

    @SerializedName("collectionName")
    @Expose
    private var collectionName: String,

    @SerializedName("collectionCensoredName")
    @Expose
    var collectionCensoredName: String,

    @SerializedName("artistViewUrl")
    @Expose
    private var artistViewUrl: String,

    @SerializedName("collectionViewUrl")
    @Expose
    private var collectionViewUrl: String,

    @SerializedName("artworkUrl60")
    @Expose
    private var artworkUrl60: String,

    @SerializedName("artworkUrl100")
    @Expose
    var artworkUrl100: String,

    @SerializedName("atrackCount")
    @Expose
    private var trackCount: String,

    @SerializedName("copyright")
    @Expose
    private var copyright: String,

    @SerializedName("releaseDate")
    @Expose
    private var releaseDate: String,

    @SerializedName("primaryGenreName")
    @Expose
    var primaryGenreName: String,
    
): Comparable<AlbumModel>
{
    override fun compareTo(other: AlbumModel): Int {
        return this.collectionCensoredName.compareTo(other.collectionCensoredName)
    }

}