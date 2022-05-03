package com.example.jpmc.data.repo

import android.util.Log
import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.data.net.SchoolsApi
import com.example.jpmc.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception
import javax.inject.Inject

class SchoolsListRepoImpl @Inject constructor(
    private val api: SchoolsApi
) : SchoolsListRepo {
    override suspend fun getSchoolsLs(): Resource<List<SchoolsListRemote>> {
        return try {
            val response = api.getSchools()
            Log.w("REp@", response.body().toString())
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it)
                }
            } else {
                Resource.error("Unknown Error", null)
            }

        } catch (e: Exception){
            Resource.error("Network unreachable", null)
        }
    }

    override suspend fun getSat(dbn: String): Resource<SchoolsSatRemote> {
        return try {
            val response = api.getSat(dbn)
            Log.w("NETe", response.raw().toString())
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it?.get(0))
                }
            } else {
                Resource.error("Unknown Error", null)
            }

        } catch (e: Exception){
            Resource.error("Network unreachable", null)
        }
    }

    override suspend fun getSchool(dbn: String): Resource<SchoolsListRemote> {
        return try {
            val response = api.getSchool(dbn)
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it?.get(0))
                }
            } else {
                Resource.error("Unknown Error", null)
            }
        } catch (e: Exception){
            Resource.error("Network unreachable", null)
        }
    }
}