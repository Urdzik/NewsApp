package com.example.newsapp.presenter

import android.util.Log
import com.example.newsapp.NewsContact
import com.example.newsapp.model.network.Articles
import com.example.newsapp.model.network.NewsModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val bookView: NewsContact.View,
    private val newsModel: NewsModel
) : NewsContact.Presenter, NewsContact.Model.OnFinishedListener {

    lateinit var disposable: Disposable

    override fun requestData() {
        disposable = newsModel.loadData(this)
    }

    override fun onFinished(listOfNews: List<Articles>) {
        bookView.retrieveData(listOfNews)
    }

    override fun onError(t: Throwable) {
       Log.d("TAG", t.localizedMessage)
    }

    override fun onDestroy() {
        disposable.dispose()
    }

}