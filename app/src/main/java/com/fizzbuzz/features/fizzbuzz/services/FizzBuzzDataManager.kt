package com.fizzbuzz.features.fizzbuzz.services

class FizzBuzzDataManager : FizzBuzzService {

    override suspend fun getFizzBuzzList(
        int1: Int,
        int2: Int,
        limit: Int,
        str1: String,
        str2: String
    ): List<String> {
        val fizzBuzzList = mutableListOf<String>()
        for (i in 1..limit) {
            val fizz = i % int1 == 0
            val buzz = i % int2 == 0
            fizzBuzzList.add(
                "$i ========> " +
                        when {
                            fizz && buzz -> "$str1$str2"
                            fizz -> str1
                            buzz -> str2
                            else -> i.toString()
                        }
            )
        }
        return fizzBuzzList
    }
}

