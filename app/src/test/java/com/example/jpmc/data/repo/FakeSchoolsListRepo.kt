package com.example.jpmc.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.util.Resource
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow

class FakeSchoolsListRepo : SchoolsListRepo {

    private val schoolItem = SchoolsListRemote(
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
    private val schoolItem2 = SchoolsListRemote(
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
    private val satResponse = SchoolsSatRemote(
        dbn = "",
        numOfSatTestTakers = "",
        satCriticalReadingAvgScore = "",
        satMathAvgScore = "",
        satWritingAvgScore = "",
        schoolName = ""
    )
    private val satResponse2 = SchoolsSatRemote(
        dbn = "",
        numOfSatTestTakers = "",
        satCriticalReadingAvgScore = "",
        satMathAvgScore = "",
        satWritingAvgScore = "",
        schoolName = ""
    )
    private val getSchoolsLs = mutableListOf(schoolItem, schoolItem2)
    private val getSatResults = mutableListOf(satResponse,satResponse2)


    private val _observableResult = MutableLiveData<SchoolsListRemote>()
    val observableResult: LiveData<SchoolsListRemote> = _observableResult

    private var eMsg = "error the current dbn data item not found"
    private var flagger = false

    private var shouldReturnNetworkError = false

    fun shouldReturnNetError(value: Boolean){
        shouldReturnNetworkError = value
    }


    override suspend fun getSchoolsLs(): Resource<List<SchoolsListRemote>> {
        return Resource.success(getSchoolsLs)
    }

    override suspend fun getSat(dbn: String): Resource<SchoolsSatRemote> {
        return try {
            val response = getSatResults.find { it.dbn == dbn }
            Resource.success(response)
        } catch (e: Exception){
            Resource.error("unknown error",null)
        }
    }

    override suspend fun getSchool(dbn: String): Resource<SchoolsListRemote> {
        TODO("Not yet implemented")
    }
}