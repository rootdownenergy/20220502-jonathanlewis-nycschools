package com.example.jpmc.ui.schools_list.core

import com.example.jpmc.data.model.SchoolsListRemote

sealed class SchoolsListUiState{
    object Empty: SchoolsListUiState()
    object Loading: SchoolsListUiState()
    class Loaded(val data: List<SchoolsListRemote>): SchoolsListUiState()
    class Error(val msg: String): SchoolsListUiState()
}
