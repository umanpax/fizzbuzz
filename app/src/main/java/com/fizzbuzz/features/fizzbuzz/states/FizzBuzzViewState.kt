package com.fizzbuzz.features.fizzbuzz.states


data class FizzBuzzViewState(
    val fizzBuzzList : List<String> = emptyList(),
    val loading : Boolean = false,
    val error : String = ""
)
