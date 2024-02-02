package com.fizzbuzz.features.fizzbuzz.services

interface FizzBuzzService {

    suspend fun getFizzBuzzList(int1: Int,
                                int2: Int,
                                limit: Int,
                                str1: String,
                                str2: String) : List<String>

}

