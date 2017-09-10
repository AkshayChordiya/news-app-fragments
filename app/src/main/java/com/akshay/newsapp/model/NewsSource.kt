package com.akshay.newsapp.model

/**
 * Model describing the news sources and the articles under
 * it.
 *
 * @author Akshay Chordiya
 * @since 10/09/2017
 */
data class NewsSource(
        var status: String = "",
        var source: String = "",
        var sortBy: String = "",
        var articles: List<NewsArticles> = emptyList())