package com.example.catalogfilms.data.repository

import com.example.catalogfilms.data.api.MoviesAPI
import com.example.catalogfilms.data.models.ThemoviedbResponse
import com.example.catalogfilms.domain.models.MovieModel
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val api:MoviesAPI):MoviesRepository {
    override suspend fun getMovies(): List<MovieModel> {
        return api.getMovies().body()!!.mapThemoviedbResponse()
    }

}