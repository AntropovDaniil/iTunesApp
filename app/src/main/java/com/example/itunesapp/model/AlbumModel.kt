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
    var artistName: String,

    @SerializedName("collectionCensoredName")
    @Expose
    var collectionCensoredName: String,

    @SerializedName("artworkUrl100")
    @Expose
    var artworkUrl100: String,

    @SerializedName("trackCount")
    @Expose
    var trackCount: String,

    @SerializedName("releaseDate")
    @Expose
    var releaseDate: String,

    @SerializedName("primaryGenreName")
    @Expose
    var primaryGenreName: String,
    
): Comparable<AlbumModel>, Parcelable
{
    override fun compareTo(other: AlbumModel): Int {
        return this.collectionCensoredName.compareTo(other.collectionCensoredName)
    }

}