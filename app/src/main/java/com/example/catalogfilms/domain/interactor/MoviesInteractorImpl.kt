package com.example.catalogfilms.domain.interactor

import com.example.catalogfilms.data.models.ThemoviedbResponse
import com.example.catalogfilms.data.repository.MoviesRepository
import com.example.catalogfilms.domain.models.MovieModel
import javax.inject.Inject

class MoviesInteractorImpl @Inject constructor(private val repository: MoviesRepository):MoviesInteractor {
    override suspend fun getMovies(): ThemoviedbResponse {
        return repository.getMovies()
    }
}