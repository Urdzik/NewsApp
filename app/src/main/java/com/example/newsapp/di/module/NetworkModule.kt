package com.example.newsapp.di.module


import com.example.newsapp.model.network.NewsApi
import com.example.newsapp.model.network.NewsModel
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Reusable
    @Provides
    internal fun provideRetrofitInterface(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://newsapi.org/v2/")
        .build()

    @Reusable
    @Provides
    internal fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

    @Reusable
    @Provides
    internal fun provideRemoteSource(api: NewsApi): NewsModel = NewsModel(api)

}