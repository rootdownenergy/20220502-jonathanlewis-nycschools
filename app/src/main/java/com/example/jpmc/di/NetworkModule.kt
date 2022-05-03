package com.example.jpmc.di

import com.example.jpmc.data.net.SchoolsApi
import com.example.jpmc.di.util.Routing
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofitApi(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Routing.schoolsApi)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    @Provides
    @Singleton
    fun provideSchoolsApi(retrofit: Retrofit): SchoolsApi = retrofit.create(SchoolsApi::class.java)
}