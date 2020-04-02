package com.example.newsapp.di

import com.example.newsapp.di.module.NetworkModule
import com.example.newsapp.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

// TODO add View Module
@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(homeFragment: HomeFragment)
}