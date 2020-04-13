package com.example.newsapp.model.network

import android.annotation.SuppressLint
import android.util.Log
import com.example.newsapp.NewsContact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class NewsModel @Inject constructor(private val api: NewsApi) : NewsContact.Model {

    override fun loadData(onFinishedListener: NewsContact.Model.OnFinishedListener): Disposable =
        api.fetchNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onFinishedListener.onFinished(it.articles)
            }, {
                onFinishedListener.onError(it.fillInStackTrace())
            })


}