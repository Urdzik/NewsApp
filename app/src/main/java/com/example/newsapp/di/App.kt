package com.example.newsapp.di

import android.app.Application

class App :Application(){
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()

            .build()
    }
}