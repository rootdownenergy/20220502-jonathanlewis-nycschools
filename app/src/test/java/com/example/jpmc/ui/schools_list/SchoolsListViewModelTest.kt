package com.example.jpmc.ui.schools_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.jpmc.data.repo.FakeSchoolsListRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class SchoolsListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //props and other assignments
    private lateinit var vm: SchoolsListViewModel
    @Before
    fun setup(){
        vm = SchoolsListViewModel(FakeSchoolsListRepo(), StandardTestDispatcher())
    }

}