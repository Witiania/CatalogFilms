package com.example.catalogfilms.data.api


import com.example.catalogfilms.data.models.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {

    @GET ("svc/movies/v2/reviews/all.json")
    suspend fun getMovies (@Query("api-key") api_key: String = "oBTo5RvfozCPv1YYqDtgolxEKl6odGqF"):Response<Movie>
  }