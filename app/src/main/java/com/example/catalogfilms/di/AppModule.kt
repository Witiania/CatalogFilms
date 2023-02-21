package com.example.catalogfilms.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
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