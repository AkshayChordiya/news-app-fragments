package com.akshay.newsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Builds retrofit configuration.
 * It is not the ideal way to build the retrofit instance.
 *
 * It's recommended to use Dagger to build a singleton instance or
 * use singleton pattern to build the retrofit instance.
 *
 * @author Akshay Chordiya
 * @since 10/09/2017
 */
class RetrofitHelper {

    /**
     * Kinda like a static block in Java
     */
    companion object {
        val BASE_URL = "https://newsapi.org/v1/"
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}