package com.example.itunesapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Class of Top Album entities which shown in the app start
 */
@Parcelize
data class TopAlbumModel(

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("artistName")
    @Expose
    val artistName: String,

    @SerializedName("releaseDate")
    @Expose
    val releaseDate: String,

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String,

    @SerializedName("name")
    @Expose
    val collectionCensoredName: String,

    @SerializedName("genres")
    @Expose
    val genres: List<GenreModel>

):  Parcelable {
}