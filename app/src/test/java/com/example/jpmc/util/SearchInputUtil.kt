package com.example.jpmc.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SearchInputUtilTest {

    @Test
    fun `empty dbn returns false`(){
        val result = SearchInputUtil.validateSearchDbnInput(
            searchQuery = ""
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `input is not a valid sat result`(){
        val result = SearchInputUtil.validateSearchDbnInput(
            searchQuery = ""
        )
        assertThat(result).isTrue()
    }
    @Test
    fun `valid search input and is sat-edu returns true`(){
        val result = SearchInputUtil.validateSearchDbnInput(
            searchQuery = ""
        )
        assertThat(result).isTrue()
    }
}