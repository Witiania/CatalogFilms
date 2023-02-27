package com.example.catalogfilms.data.api



import com.example.catalogfilms.data.models.ResultX
import com.example.catalogfilms.data.models.ThemoviedbResponse
import com.example.catalogfilms.data.models.Videos
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    @GET ("3/movie/popular?api_key=c58759b468299400b08edcaa65e07e47&language=en-US&page=1")
    suspend fun getMovies ():Response<ThemoviedbResponse>
    //@Query("api-key") api_key: String = "c58759b468299400b08edcaa65e07e47"

    @GET("3/movie/{movie_id}/videos?api_key=c58759b468299400b08edcaa65e07e47&language=en-US")
    suspend fun getTrailers(@Path("movie_id")id:Int):Response<Videos>

  }
