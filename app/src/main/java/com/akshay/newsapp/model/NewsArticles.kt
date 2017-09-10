package com.akshay.newsapp.model

/**
 * Model describing the news article details fetched from
 * Google News.
 *
 * @author Akshay Chordiya
 * @since 10/09/2017
 */
data class NewsArticles(
        var author: String = "",
        var title: String = "",
        var description: String = "",
        var url: String = "",
        var urlToImage: String = "",
        var publishedAt: String = "")