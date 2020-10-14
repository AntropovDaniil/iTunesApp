package com.example.itunesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {

    /**
     * Method gets albums by entered words
     */
    @GET("search")
    fun getAlbums(@Query("term") term: String?,
                  @Query ("entity") entity: String = "album",
                  @Query ("attribute") attribute: String = "albumTerm",
                  @Query ("media") media: String = "music",
                  @Query ("limit") limit: String = "50"): Call<PostAlbum>

    /**
     * Method gets list of songs of selected album
     */
    @GET("lookup")
    fun getTracks(@Query("id") id: String?,
                  @Query("entity") entity: String = "song") : Call<PostTrack>

    /**
     * Method gets top 20 albums in ITunes
     */
    @GET("api/v1/us/itunes-music/top-albums/all/20/explicit.json")
    fun getTopAlbums(): Call<PostAlbum>
}