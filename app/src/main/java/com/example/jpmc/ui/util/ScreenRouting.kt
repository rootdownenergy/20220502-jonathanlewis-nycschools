package com.example.jpmc.ui.util

sealed class ScreenRouting(val route: String) {
    object SchoolsListScreen : ScreenRouting("schools_screen")
    object SchoolDetailScreen : ScreenRouting("sat_screen")
}