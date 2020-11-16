package com.example.itunesapp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Class of Album Entity
 */
@Parcelize
data class AlbumModel(

    @SerializedName("collectionId")
    @Expose
    val collectionId: String,

    @SerializedName("artistName")
    @Expose
    val artistName: String,

    @SerializedName("collectionCensoredName")
    @Expose
    val collectionCensoredName: String,

    @SerializedName("artworkUrl100")
    @Expose
    val artworkUrl100: String,

    @SerializedName("trackCount")
    @Expose
    val trackCount: String,

    @SerializedName("releaseDate")
    @Expose
    val releaseDate: String,

    @SerializedName("primaryGenreName")
    @Expose
    val primaryGenreName: String,
    
): Comparable<AlbumModel>, Parcelable
{
    override fun compareTo(other: AlbumModel): Int {
        return this.collectionCensoredName.compareTo(other.collectionCensoredName)
    }

}