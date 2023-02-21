package com.example.catalogfilms.data.models

data class ThemoviedbResponse(
    val page: Int,
    val results: List<Result2>,
    val total_pages: Int,
    val total_results: Int
)