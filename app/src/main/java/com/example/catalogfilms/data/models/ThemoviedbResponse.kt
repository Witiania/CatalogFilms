package com.example.catalogfilms.data.models

data class ThemoviedbResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
