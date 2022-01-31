package com.example.palnews

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScienceFragment: Fragment(), ItemClicked, ShareClicked {

    private val api: String = "dda4d2f20deb4dc1902db6e81d1c547b"
    lateinit var newsDataList: ArrayList<NewsData>
    lateinit var adapter: NewsAdapter
    private val country = "in"
    private val category = "science"
    private lateinit var recyclerViewOfScience: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.science_fragment, null)

        recyclerViewOfScience = view.findViewById(R.id.recyclerViewForScience)
        newsDataList = ArrayList()

        recyclerViewOfScience.layoutManager = LinearLayoutManager(context)

        adapter = NewsAdapter(this,this,newsDataList)
        recyclerViewOfScience.adapter = adapter

        findNews()

        return view
    }

    override fun onClickedItem(element: NewsData) {

        val builder =  CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(element.url))
    }

    override fun onShareClicked(element: NewsData) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,element.url)

        val chooser = Intent.createChooser(intent,"News Link")
        startActivity(chooser)
    }

    private fun findNews(){

        ApiUtilities.getApiInterface()?.getCategoryNews(country,category,100,api)?.enqueue(object:
            Callback<MainNewsData> {

            override fun onResponse(call: Call<MainNewsData>, response: Response<MainNewsData>) {

                if(response.isSuccessful)
                {
                    response.body()?.articles?.let { newsDataList.addAll(it) }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainNewsData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}
