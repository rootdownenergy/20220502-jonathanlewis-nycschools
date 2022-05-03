package com.example.jpmc.ui.schools_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpmc.data.repo.SchoolsListRepoImpl
import com.example.jpmc.di.util.DefaultDispatcher
import com.example.jpmc.ui.schools_list.core.SchoolsListUiState
import com.example.jpmc.ui.schools_list.core.SchoolsState
import com.example.jpmc.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsListViewModel @Inject constructor(
    private val repo: SchoolsListRepoImpl,
    private val savedStateHandle: SavedStateHandle,
    @DefaultDispatcher val defaultDispatcher: CoroutineDispatcher
): ViewModel() {

    // post UI States for collection by view
    /*
    *  MutableStateFlow<SchoolsListUiState> && backing field
    *
    * */
    private val _uiState = MutableStateFlow<SchoolsListUiState>(SchoolsListUiState.Empty)
    val uiState: StateFlow<SchoolsListUiState> = _uiState

    private val _state = mutableStateOf(SchoolsState())
    val state: State<SchoolsState> = _state


    init {
        getSchoolsLs()
        Log.w("VM!","INIT VM")
    }

    private fun getSchoolsLs(){
        _uiState.value = SchoolsListUiState.Loading
        Log.w("VM!","IN GET SCHOOLS")
        viewModelScope.launch(defaultDispatcher) {
            Log.w("VM!","INIT Coroutine")
            val response = repo.getSchoolsLs()
            if(response.status == Status.SUCCESS){
                _uiState.value = SchoolsListUiState.Loaded(response.data!!)
            } else {
                _uiState.value = SchoolsListUiState.Error(response.message.toString())
            }
        }
    }

}