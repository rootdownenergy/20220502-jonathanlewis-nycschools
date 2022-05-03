package com.example.jpmc.ui.schools_list.core


import com.example.jpmc.data.model.SchoolsListRemote

data class SchoolsState(
    val schools: List<SchoolsListRemote> = listOf()
)