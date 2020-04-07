package com.example.newsapp.di

import com.example.newsapp.di.module.MainPresenterModule
import com.example.newsapp.di.module.NetworkModule
import com.example.newsapp.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, MainPresenterModule::class])
interface AppComponent {
    fun inject(homeFragment: HomeFragment)
}