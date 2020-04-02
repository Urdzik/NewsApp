package com.example.newsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.di.App
import com.example.newsapp.presenter.MainPresenter
import javax.inject.Inject

class HomeFragment : Fragment() {

//    @Inject
//    lateinit var presenter: MainPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

//        App.appComponent.inject(this)


        return inflater.inflate(R.layout.home_fragment, container, false)
    }



}
