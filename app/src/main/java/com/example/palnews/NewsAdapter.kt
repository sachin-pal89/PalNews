package com.example.palnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class NewsAdapter(private val listener: ItemClicked,private val listenerShare: ShareClicked, private val list: ArrayList<NewsData>): RecyclerView.Adapter<NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_view,parent,false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onClickedItem(list[viewHolder.absoluteAdapterPosition])
        }

        val share: MaterialButton = view.findViewById(R.id.shareButton)
        share.setOnClickListener{
            listenerShare.onShareClicked(list[viewHolder.absoluteAdapterPosition])
        }

        return viewHolder
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currItem = list[position]
        holder.titleView.text = currItem.title

        if(currItem.author != "null") holder.authorView.text = currItem.author
        else holder.authorView.text = currItem.name

        Glide.with(holder.imageView.context).load(currItem.urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.newsImage)
    val titleView: TextView = itemView.findViewById(R.id.newsTitle)
    val authorView: TextView = itemView.findViewById(R.id.newsAuthor)
}

interface ItemClicked{
    fun onClickedItem(element: NewsData)
}

interface ShareClicked{
    fun onShareClicked(element: NewsData)
}