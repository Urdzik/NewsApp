package com.example.newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newsapp.NewsContact
import com.example.newsapp.databinding.HomeFragmentBinding
import com.example.newsapp.di.DaggerAppComponent
import com.example.newsapp.di.module.MainPresenterModule
import com.example.newsapp.model.network.Articles
import com.example.newsapp.presenter.MainPresenter
import com.example.newsapp.utils.adapters.NewsAdapter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeFragment : Fragment(), NewsContact.View {

    @Inject
    lateinit var presenter: MainPresenter
  lateinit  var adapter: NewsAdapter
    lateinit var binding: HomeFragmentBinding
    val disposeBag = CompositeDisposable()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater)




        DaggerAppComponent
            .builder()
            .mainPresenterModule(MainPresenterModule(this))
            .build()
            .inject(this)

       adapter = NewsAdapter(this.context)
        binding.recycler.adapter = adapter
        Log.e("TAG", "one")


        disposeBag.add(
            adapter.clickEvent.subscribe({article ->
                Toast.makeText(context, article.url, Toast.LENGTH_SHORT).show()
                binding.web.loadUrl(article.url)

            }, {

            })
        )

        presenter.requestData()
        return binding.root
    }


    override fun retrieveData(listOfNews: List<Articles>) {
        Log.e("TAG", "two")

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
