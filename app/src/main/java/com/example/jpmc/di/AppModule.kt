package com.example.jpmc.di

import com.example.jpmc.data.net.SchoolsApi
import com.example.jpmc.data.repo.SchoolsListRepo
import com.example.jpmc.data.repo.SchoolsListRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSchoolsListRepo(
        api: SchoolsApi
    ) = SchoolsListRepoImpl(api) as SchoolsListRepo
}