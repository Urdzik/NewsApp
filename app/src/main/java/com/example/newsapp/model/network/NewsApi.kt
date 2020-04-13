package com.example.newsapp.model.network

import io.reactivex.Single
import retrofit2.http.GET

interface NewsApi{
    @GET("top-headlines?country=us&apiKey=de3fce4d083c4de3aee55c412b44f79e")
    fun fetchNews(): Single<News>
}