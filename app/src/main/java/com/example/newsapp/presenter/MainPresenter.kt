package com.example.newsapp.presenter

import com.example.newsapp.NewsContact
import com.example.newsapp.model.network.News

class MainPresenter (private val bookView: NewsContact.View): NewsContact.Presenter, NewsContact.Model.OnFinishedListener{

    override fun requestData() {
        TODO("Not yet implemented")
    }

    override fun onFinished(listOfNews: List<News>) {
        TODO("Not yet implemented")
    }

    override fun onError(t: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}