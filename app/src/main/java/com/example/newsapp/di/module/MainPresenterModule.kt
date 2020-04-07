package com.example.newsapp.di.module

import android.view.View
import com.example.newsapp.NewsContact
import com.example.newsapp.model.network.NewsModel
import dagger.Module
import dagger.Provides

@Module
class MainPresenterModule(var view: NewsContact.View) {

    @Provides
    fun provideNewsContact(): NewsContact.View = view


}