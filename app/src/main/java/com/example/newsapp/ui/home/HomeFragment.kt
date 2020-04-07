package com.example.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsapp.NewsContact
import com.example.newsapp.R
import com.example.newsapp.di.App
import com.example.newsapp.di.DaggerAppComponent
import com.example.newsapp.di.module.MainPresenterModule
import com.example.newsapp.model.network.Articles
import com.example.newsapp.presenter.MainPresenter
import javax.inject.Inject

class HomeFragment : Fragment(), NewsContact.View {

    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        App.appComponent.inject(this)



        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun retrieveData(listOfNews: List<Articles>) {
        TODO("Not yet implemented")
    }

    override fun onError(t: Throwable) {
        TODO("Not yet implemented")
    }


}
