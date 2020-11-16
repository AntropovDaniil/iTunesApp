package com.example.itunesapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Class of genre entity for list of genres in TopAlbumModel
 */
@Parcelize
data class GenreModel(
    @SerializedName("genreId")
    @Expose
    val genreId: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("url")
    @Expose
    val url: String
): Parcelable {
}