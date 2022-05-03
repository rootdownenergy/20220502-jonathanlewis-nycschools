package com.example.jpmc.data.repo

import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.util.Resource
import kotlinx.coroutines.flow.Flow

interface SchoolsListRepo {
    suspend fun getSchoolsLs(): Resource<List<SchoolsListRemote>>
    suspend fun getSat(dbn: String): Resource<SchoolsSatRemote>
    suspend fun getSchool(dbn: String): Resource<SchoolsListRemote>
}