package com.example.itunesapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post() {

    @SerializedName("resultCount")
    @Expose
    lateinit var resultCount: Integer

    @SerializedName("results")
    @Expose
    lateinit var resultModels: List<ResultModel>


}