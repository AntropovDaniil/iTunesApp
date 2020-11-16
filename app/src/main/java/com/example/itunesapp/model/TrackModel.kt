package com.example.itunesapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrackModel(

    @SerializedName("artistId")
    @Expose
    val artistId: String,

    @SerializedName("collectionId")
    @Expose
    val collectionId: String,

    @SerializedName("trackId")
    @Expose
    val trackId: String,

    @SerializedName("artistName")
    @Expose
    val artistName: String,

    @SerializedName("collectionName")
    @Expose
    val collectionName: String,

    @SerializedName("trackName")
    @Expose
    val trackName: String,

    @SerializedName("collectionCensoredName")
    @Expose
    val collectionCensoredName: String,

    @SerializedName("trackCensoredName")
    @Expose
    val trackCensoredName: String,

    @SerializedName("artistViewUrl")
    @Expose
    val artistViewUrl: String,

    @SerializedName("collectionViewUrl")
    @Expose
    val collectionViewUrl: String,

    @SerializedName("trackViewUrl")
    @Expose
    val trackViewUrl: String,

    @SerializedName("previewUrl")
    @Expose
    val previewUrl: String,

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String,

    @SerializedName("trackTimeMillis")
    @Expose
    val trackTimeMillis:String

    ): Parcelable
{
}