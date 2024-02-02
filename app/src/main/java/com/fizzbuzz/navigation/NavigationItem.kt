package com.fizzbuzz.navigation

sealed class NavigationItem(var route: String, var title: String) {
    object FizzBuzz : NavigationItem("FizzBuzz", "FizzBuzz")
}
