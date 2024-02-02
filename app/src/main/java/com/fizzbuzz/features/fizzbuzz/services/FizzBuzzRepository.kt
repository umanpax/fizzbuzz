package com.fizzbuzz.features.fizzbuzz.services

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FizzBuzzRepository(private val dataManager: FizzBuzzDataManager) {

    fun getFizzBuzzList(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ): Flow<List<String>> = flow {
        val response = dataManager.getFizzBuzzList(int1, int2, limit, str1, str2)
        if (response.isNotEmpty()) emit(response)
        else emit(emptyList())
    }
}
