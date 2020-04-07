package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.di.module.MainPresenterModule
import com.example.newsapp.ui.home.HomeFragment

class App :Application(){
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .mainPresenterModule(MainPresenterModule(HomeFragment()))
            .build()
    }
}