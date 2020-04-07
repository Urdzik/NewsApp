package com.example.newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsapp.NewsContact
import com.example.newsapp.databinding.HomeFragmentBinding
import com.example.newsapp.di.App
import com.example.newsapp.model.network.Articles
import com.example.newsapp.presenter.MainPresenter
import com.example.newsapp.utils.adapters.MainAdapter
import javax.inject.Inject

class HomeFragment : Fragment(), NewsContact.View {


    @Inject
    lateinit var presenter: MainPresenter
    lateinit var adapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HomeFragmentBinding.inflate(inflater)

        App.appComponent.inject(this)

        adapter = MainAdapter()
        binding.recycler.adapter = adapter



        return binding.root
    }

    override fun retrieveData(listOfNews: List<Articles>) {
        adapter.submitList(listOfNews)
    }

    override fun onError(t: Throwable) {
       Log.e("TAG", "Error in HomeFragment", t)
    }


}
