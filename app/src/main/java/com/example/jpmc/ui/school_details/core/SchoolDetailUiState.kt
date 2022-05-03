package com.example.jpmc.ui.school_details.core

import com.example.jpmc.data.model.SchoolsListRemote
import com.example.jpmc.data.model.SchoolsSatRemote
import com.example.jpmc.ui.schools_list.core.SchoolsListUiState

sealed class SchoolDetailUiState {
    object Empty: SchoolDetailUiState()
    object Loading: SchoolDetailUiState()
    class Loaded(val dataSat: SchoolsSatRemote, val dataSchool: SchoolsListRemote): SchoolDetailUiState()
    class Error(val msg: String): SchoolDetailUiState()
}
