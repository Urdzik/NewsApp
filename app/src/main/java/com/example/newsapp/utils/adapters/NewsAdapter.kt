package com.example.newsapp.utils.adapters

import com.example.newsapp.R
import com.example.newsapp.model.network.Articles



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item.view.*


class NewsAdapter(private val context: Context?) : ListAdapter<Articles, NewsAdapter.DataViewHolder>(
    DiffCallback()
) {

    private val clickSubject = PublishSubject.create<Articles>()
    val clickEvent: PublishSubject<Articles> = clickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    inner class DataViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(book: Articles) {

            view.title_item.text = book.title



            Glide
                .with(view.imageView.context)
                .load(book.urlToImage)
                .apply(
                    RequestOptions()

                )
                .into(view.imageView)


            //onClick by recycler item
            view.setOnClickListener {
                clickEvent.onNext(book)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Articles>() {
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem.title == newItem.title
    }

}
