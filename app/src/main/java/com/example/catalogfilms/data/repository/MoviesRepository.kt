package com.example.catalogfilms.data.repository

import com.example.catalogfilms.data.models.ThemoviedbResponse
import retrofit2.Response

interface MoviesRepository {
    suspend fun getMovies (): ThemoviedbResponse
}