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

    private val adapter: MainAdapter = MainAdapter()
    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HomeFragmentBinding.inflate(inflater)

        App.appComponent.inject(this)

        binding.recycler.adapter = adapter

        presenter.requestData()

        return binding.root
    }

    override fun retrieveData(listOfNews: List<Articles>) {
        Log.e("TAG", "${listOfNews.toString()}")
            adapter.submitList(listOfNews)
    }

    override fun onError(t: Throwable) {
       Log.e("TAG", "Error in HomeFragment", t)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
