package com.fizzbuzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.fizzbuzz.navigation.Navigation
import com.fizzbuzz.ui.theme.FizzBuzzTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            FizzBuzzTheme {
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}



