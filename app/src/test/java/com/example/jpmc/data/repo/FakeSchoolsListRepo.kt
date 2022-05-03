package com.example.jpmc.data.repo

import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.util.Resource
import kotlinx.coroutines.flow.Flow

class FakeSchoolsListRepo : SchoolsListRepo {
    override suspend fun getSchoolsLs(): Resource<List<SchoolsListRemote>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSat(dbn: String): Resource<SchoolsSatRemote> {
        TODO("Not yet implemented")
    }

    override suspend fun getSchool(dbn: String): Resource<SchoolsListRemote> {
        TODO("Not yet implemented")
    }
}