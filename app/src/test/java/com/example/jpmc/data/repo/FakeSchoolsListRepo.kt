package com.example.jpmc.data.repo

import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.util.Resource
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow

class FakeSchoolsListRepo : SchoolsListRepo {

    val schoolItem = SchoolsListRemote(
        academicopportunities1 = "",
        academicopportunities2 = "",
        admissionspriority11 = "",
        admissionspriority21 = "",
        admissionspriority31 = "",
        attendanceRate = "",
        bbl = "",
        bin = "",
        boro = "",
        borough = "",
        buildingCode = "",
        bus = "",
        censusTract = "",
        city = "",
        code1 = "",
        communityBoard = "",
        councilDistrict = "",
        dbn = "",
        directions1 = "",
        ellPrograms = "",
        extracurricularActivities = "",
        faxNumber = "",
        finalgrades = "",
        grade9geapplicants1 = "",
        grade9geapplicantsperseat1 = "",
        grade9gefilledflag1 = "",
        grade9swdapplicants1 = "",
        grade9swdapplicantsperseat1 = "",
        grade9swdfilledflag1 = "",
        grades2018 = "",
        interest1 = "",
        latitude = "",
        location = "",
        longitude = "",
        method1 = "",
        neighborhood = "",
        nta = "",
        offerRate1 = "",
        overviewParagraph = "",
        pctStuEnoughVariety = "",
        pctStuSafe = "",
        phoneNumber = "",
        primaryAddressLine1 = "",
        program1 = "",
        requirement11 = "",
        requirement21 = "",
        requirement31 = "",
        requirement41 = "",
        requirement51 = "",
        school10thSeats = "",
        schoolAccessibilityDescription = "",
        schoolEmail = "",
        schoolName = "",
        schoolSports = "",
        seats101 = "",
        seats9ge1 = "",
        seats9swd1 = "",
        stateCode = "",
        subway = "",
        totalStudents = "",
        website = "",
        zip = ""
    )
    val getSchoolsLs: List<SchoolsListRemote> = listOf(schoolItem, schoolItem)


    override suspend fun getSchoolsLs(): Resource<List<SchoolsListRemote>> {
        return Resource.success(getSchoolsLs)
    }

    override suspend fun getSat(dbn: String): Resource<SchoolsSatRemote> {
        TODO("Not yet implemented")
    }

    override suspend fun getSchool(dbn: String): Resource<SchoolsListRemote> {
        TODO("Not yet implemented")
    }
}