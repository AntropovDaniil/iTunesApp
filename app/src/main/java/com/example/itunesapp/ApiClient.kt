package com.example.itunesapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  An object that generates an implementation of the ITunes Service Api interface
 */

object ApiClient {

    val BASE_URL = "https://itunes.apple.com/"
    val BASE_RSS_URL = "https://rss.itunes.apple.com/"

    /**
     * Method for getting a list of albums which user has searched
     */
    val getSearchAlbums: ITunesApi
            get() {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(ITunesApi::class.java);
    }

    /**
     * Method for getting top 20 albums in ITunes on the app start
     */
    val getTopAlbums: ITunesApi
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_RSS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ITunesApi::class.java);
        }

}