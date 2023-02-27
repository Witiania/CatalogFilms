package com.example.catalogfilms.data.repository

import com.example.catalogfilms.data.models.ThemoviedbResponse
import com.example.catalogfilms.domain.models.MovieModel
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies (): List<MovieModel>
}