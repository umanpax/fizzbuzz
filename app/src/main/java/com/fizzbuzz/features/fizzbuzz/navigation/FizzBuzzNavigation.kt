package com.fizzbuzz.features.fizzbuzz.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fizzbuzz.features.fizzbuzz.screens.FizzBuzzScreen
import com.fizzbuzz.navigation.NavigationItem

fun NavGraphBuilder.fizzBuzzScreen() {
    composable(
        route = NavigationItem.FizzBuzz.route,
    ) {
        FizzBuzzScreen()
    }
}
