package com.example.catalogfilms.presentation.screens.list_films

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogfilms.data.models.ThemoviedbResponse
import com.example.catalogfilms.domain.interactor.MoviesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListMoviesViewModel @Inject constructor(private val interactor: MoviesInteractor):ViewModel() {


    val listMoviesLiveData = MutableLiveData<ThemoviedbResponse>()

    init{
        getListMovies()
    }

    private fun getListMovies(){
        viewModelScope.launch {
            listMoviesLiveData.value = interactor.getMovies()
        }
    }
}