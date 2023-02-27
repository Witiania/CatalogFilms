package com.example.catalogfilms.data.retrofit

import com.example.catalogfilms.data.api.MoviesAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Retrofit @Inject constructor() {
    private val client = OkHttpClient().newBuilder().addInterceptor(
        HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY)).build()

       private var BASE_URL = "https://api.themoviedb.org/"

        fun getMoviesApiInterface () = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(MoviesAPI::class.java)

}