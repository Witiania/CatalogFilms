package com.example.catalogfilms.data.models

import com.example.catalogfilms.domain.models.MovieModel

data class ThemoviedbResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
){
    fun mapThemoviedbResponse():List<MovieModel>{
        return arrayListOf<MovieModel>().apply {
            results.forEach {
                add(
                    MovieModel(
                        title = it.title,
                        release_date = it.release_date,
                        poster_path = "https://image.tmdb.org/t/p/w600_and_h900_bestv2" + it.poster_path
                )
                )
            }
        }
    }
}
