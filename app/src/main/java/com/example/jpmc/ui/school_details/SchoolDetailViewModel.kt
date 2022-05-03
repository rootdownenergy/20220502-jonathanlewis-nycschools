package com.example.jpmc.ui.school_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.data.repo.SchoolsListRepo
import com.example.jpmc.di.util.DefaultDispatcher
import com.example.jpmc.ui.school_details.core.SchoolDetailUiState
import com.example.jpmc.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val repo: SchoolsListRepo,
    savedStateHandle: SavedStateHandle,
    @DefaultDispatcher val defaultCoroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    // post UI States for collection by view
    /*
    *  MutableStateFlow<SchoolsDetailUiState> && backing field
    *
    * */
    private val _uiState = MutableStateFlow<SchoolDetailUiState>(SchoolDetailUiState.Empty)
    val uiState: StateFlow<SchoolDetailUiState> = _uiState

    init {
        Log.w("VM2", "IN VM DETAILS")
        _uiState.value = SchoolDetailUiState.Loading
        savedStateHandle.get<String>("dbn").let { dbn ->
            if (dbn != null) {
                if(dbn.isNotBlank()){
                    viewModelScope.launch(defaultCoroutineDispatcher) {
                        val response1 = repo.getSat(dbn)
                        val response2 = repo.getSchool(dbn)
                        if(response1.status == Status.SUCCESS || response2.status == Status.SUCCESS){
                            // assign responses or default
                            if(response1.data != null && response2.data != null){
                                _uiState.value = SchoolDetailUiState.Loaded(response1.data,response2.data)
                            } else if (response1.data == null && response2.data != null){
                                val response = SchoolsSatRemote(
                                    dbn = "",
                                    numOfSatTestTakers = "",
                                    satCriticalReadingAvgScore = "",
                                    satMathAvgScore = "",
                                    satWritingAvgScore = "",
                                    schoolName = ""
                                )
                                _uiState.value = SchoolDetailUiState.Loaded(response,response2.data)
                            } else if(response1.data == null && response2.data == null) {
                                _uiState.value = SchoolDetailUiState.Error("No Data Available")
                            }
                        }
                    }
                }
            } else {
                _uiState.value = SchoolDetailUiState.Error("Uknown error occured")
            }
        }
    }
}