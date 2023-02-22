package com.example.catalogfilms.data.repository

import com.example.catalogfilms.data.api.MoviesAPI
import com.example.catalogfilms.data.models.ThemoviedbResponse
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val api:MoviesAPI):MoviesRepository {
    override suspend fun getMovies(): ThemoviedbResponse {
        return api.getMovies().body()!!
    }

}