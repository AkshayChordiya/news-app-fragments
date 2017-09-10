package com.akshay.newsapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

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
    }
}
