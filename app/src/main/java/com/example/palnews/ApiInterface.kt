package com.example.palnews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    val BASE_URL: String
      get() = "https://newsapi.org/v2/"

    @GET("top-headlines")
    fun getNews(
             @Query("country") country: String,
             @Query("pageSize") pageSize: Int,
             @Query("apiKey") apiKey: String
    ): Call<MainNewsData>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String
    ): Call<MainNewsData>
}