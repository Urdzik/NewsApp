package com.example.newsapp.utils.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemBinding
import com.example.newsapp.model.network.Articles
import io.reactivex.subjects.PublishSubject


class MainAdapter : ListAdapter<Articles, MainAdapter.NewsViewHolder>(DiffCallBack()) {

    private val clickSubject = PublishSubject.create<Articles>()
    val clickEvent: PublishSubject<Articles> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
      val item = getItem(position)
        holder.bind(item)
    }

    inner class NewsViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(articles: Articles){

            binding.root.setOnClickListener {
                clickEvent.onNext(articles)
            }
        }
    }

}

class DiffCallBack : DiffUtil.ItemCallback<Articles>() {
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean =
        oldItem.url == newItem.url

}

