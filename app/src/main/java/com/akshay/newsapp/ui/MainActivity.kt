package com.akshay.newsapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.api.NewsArticleService
import com.akshay.newsapp.api.RetrofitHelper
import com.akshay.newsapp.model.NewsSource
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The Launcher Activity.
 *
 * @author Akshay Chordiya
 * @since 10/09/2017
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up RecyclerView and adapter
        val adapter = NewsArticlesAdapter {
            toast("Clicked on item")
        }
        news_list.adapter = adapter
        news_list.layoutManager = LinearLayoutManager(this)

        val newsArticleService = RetrofitHelper.retrofit.create(NewsArticleService::class.java)
        val newsArticles = newsArticleService.getAllNewsArticles()
        newsArticles.enqueue(object : Callback<NewsSource> {
            override fun onResponse(call: Call<NewsSource>?, response: Response<NewsSource>?) {
                response?.body()?.let { newsSource ->
                    // Update the UI with the data
                    adapter.swapItems(newsSource.articles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<NewsSource>?, t: Throwable?) {
                toast("Unable to fetch the news")
            }
        })
    }
}
