package com.fizzbuzz.di

import com.fizzbuzz.features.fizzbuzz.services.FizzBuzzDataManager
import com.fizzbuzz.features.fizzbuzz.services.FizzBuzzRepository
import com.fizzbuzz.features.fizzbuzz.viewmodels.FizzBuzzViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val moduleFizzBuzzRepository =
    module { factory { FizzBuzzRepository(dataManager = FizzBuzzDataManager()) } }


val fizzbuzzViewModel = module {
    viewModel {
        FizzBuzzViewModel(repository = FizzBuzzRepository(dataManager = FizzBuzzDataManager()))
    }
}


val koinUiModules = listOf(
    fizzbuzzViewModel,
    moduleFizzBuzzRepository
)