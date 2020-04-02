package com.example.newsapp

import com.example.newsapp.model.network.Articles
import com.example.newsapp.model.network.News
import io.reactivex.disposables.Disposable

interface NewsContact {
    interface Model {
        interface OnFinishedListener {
            fun onFinished(listOfNews: List<Articles>)
            fun onError(t: Throwable)
        }

        fun loadData(onFinishedListener: OnFinishedListener): Disposable
    }

    interface Presenter {

        fun requestData()

        fun onDestroy()

    }

    interface View {
        fun retrieveData(listOfNews: List<Articles>)

        fun onError(t: Throwable)

    }
}