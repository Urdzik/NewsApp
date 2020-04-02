package com.example.newsapp.model.network

import com.example.newsapp.utils.API_KEY
import retrofit2.http.GET

interface NewsApi{
    @GET("top-headlines?country=us&apiKey=$API_KEY")
    fun fetchNews(){}
}