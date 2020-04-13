package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.di.module.MainPresenterModule
import com.example.newsapp.ui.home.HomeFragment
import io.reactivex.plugins.RxJavaPlugins

class App :Application(){
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {}
        appComponent = DaggerAppComponent
            .builder()
            .mainPresenterModule(MainPresenterModule(HomeFragment()))
            .build()
    }
}