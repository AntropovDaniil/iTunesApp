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
    var id: String,

    @SerializedName("artistName")
    @Expose
    var artistName: String,

    @SerializedName("releaseDate")
    @Expose
    var releaseDate: String,

    @SerializedName("artworkUrl100")
    @Expose
    var artworkUrl100: String,

    @SerializedName("name")
    @Expose
    var collectionCensoredName: String,

    @SerializedName("genres")
    @Expose
    var genres: List<GenreModel>

):  Parcelable {
}