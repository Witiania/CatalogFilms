package com.example.catalogfilms.domain.interactor

import com.example.catalogfilms.data.models.ThemoviedbResponse

interface MoviesInteractor {
    suspend fun getMovies (): ThemoviedbResponse
}