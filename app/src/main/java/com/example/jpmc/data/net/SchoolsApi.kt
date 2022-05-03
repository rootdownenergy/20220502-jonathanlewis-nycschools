package com.example.jpmc.data.net

import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolsApi {
    @GET("s3k6-pzi2.json")
    suspend fun getSchools(): Response<List<SchoolsListRemote>>

    @GET("f9bf-2cp4.json?")
    suspend fun getSat(@Query("dbn") dbn: String): Response<List<SchoolsSatRemote>>

    @GET("s3k6-pzi2.json?")
    suspend fun getSchool(@Query("dbn") dbn: String): Response<List<SchoolsListRemote>>
}