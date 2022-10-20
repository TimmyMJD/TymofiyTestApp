package com.adgif.timofiytestapp.di

import com.adgif.timofiytestapp.domain.IRepository
import com.adgif.timofiytestapp.data.Repository
import com.adgif.timofiytestapp.data.local.AppDatabase
import com.adgif.timofiytestapp.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule{

    @Provides
    @Singleton
    fun providesBaseUrl() : String = "https://api.giphy.com/v1/"

    @Provides
    @Singleton
    fun provideRetrofit(url : String) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(url)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService, appDatabase : AppDatabase) : IRepository =
        Repository(apiService, appDatabase)
}