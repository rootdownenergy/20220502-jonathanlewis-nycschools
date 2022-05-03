package com.example.jpmc.ui.school_details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.jpmc.data.repo.FakeSchoolsListRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class SchoolDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //props and other assignments
    private lateinit var vm: SchoolDetailViewModel
    private lateinit var repo: FakeSchoolsListRepo

    @Before
    fun setup(){
        repo = FakeSchoolsListRepo()
        vm = SchoolDetailViewModel(FakeSchoolsListRepo(), SavedStateHandle(), StandardTestDispatcher())
    }

    @Test
    fun `given dbn string assign state value`(){

    }

    @Test
    fun `given no dbn string state value set to ui state empty`(){

    }
}