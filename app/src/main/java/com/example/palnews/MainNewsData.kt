package com.example.palnews

data class MainNewsData(

    var status: String,
    var totalResults: String,
    var articles: ArrayList<NewsData>?
)


