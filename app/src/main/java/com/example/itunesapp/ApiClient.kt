package com.example.itunesapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val BASE_URL = "https://itunes.apple.com/" // search?term=Michael+Jackson
    val getClient: ITunesApi
            get() {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return retrofit.create(ITunesApi::class.java);

    }

}