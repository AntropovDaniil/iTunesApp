package com.example.itunesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {

    @GET("search")
    fun getAlbums(@Query("term") term: String?,
                  @Query ("entity") entity: String = "album",
                  @Query ("media") media: String = "music"): Call<PostAlbum>

    @GET("lookup")
    fun getTracks(@Query("id") id: String?,
                  @Query("entity") entity: String = "song") : Call<PostTrack>

}