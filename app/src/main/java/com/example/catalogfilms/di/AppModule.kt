package com.example.catalogfilms.di

import com.example.catalogfilms.data.api.MoviesAPI
import com.example.catalogfilms.data.repository.MoviesRepository
import com.example.catalogfilms.data.repository.MoviesRepositoryImpl
import com.example.catalogfilms.data.retrofit.Retrofit
import com.example.catalogfilms.domain.interactor.MoviesInteractor
import com.example.catalogfilms.domain.interactor.MoviesInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideMoviesApi(retrofit:Retrofit):MoviesAPI{
        return retrofit.getMoviesApiInterface()
    }
    @Provides
    @Singleton
    fun provideMoviesRepository(api:MoviesAPI):MoviesRepository{
        return MoviesRepositoryImpl(api)
    }
    @Provides
    @Singleton
    fun provideMoviesInteractor(repository: MoviesRepository):MoviesInteractor{
        return MoviesInteractorImpl(repository)
    }
    }


//
//interface Repository {
//    fun getData() : Int
//}
//class RepositoryImpl : Repository {
//    override fun getData(): Int {
//        val realWrok = 1
//    }
//}
//
//class TestRepositoryImpl : Repository {
//    override fun getData(): Int {
//        val testWork1 = 1
//    }
//}
//
//class ViewModel(val repository: Repository) {
//    fun test() {
//        repository.getData()
//    }
//}