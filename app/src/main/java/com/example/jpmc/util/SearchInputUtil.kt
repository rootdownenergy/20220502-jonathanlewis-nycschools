package com.example.jpmc.util

object SearchInputUtil {
    private val existingDbn = listOf<String>("","")
    /**
     * the input is not valid if the:
     * ...search input is empty
     * ...if not SAT-EDU exists
     */
    fun validateSearchDbnInput(
        searchQuery: String,
    ): Boolean {
        if(searchQuery.isEmpty()){
            return false
        }
        if(searchQuery.isNotEmpty() && searchQuery in existingDbn){
            return true
        }
        return true
    }
}