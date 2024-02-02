package com.fizzbuzz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fizzbuzz.features.fizzbuzz.navigation.fizzBuzzScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.FizzBuzz.route) {
        fizzBuzzScreen()
    }
}

