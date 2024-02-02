package com.fizzbuzz.features.fizzbuzz.viewmodels

import androidx.lifecycle.ViewModel
import com.fizzbuzz.features.fizzbuzz.services.FizzBuzzRepository
import com.fizzbuzz.features.fizzbuzz.states.FizzBuzzViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class FizzBuzzViewModel(private val repository: FizzBuzzRepository) : ViewModel(), KoinComponent {

    private val _stateStream = MutableStateFlow(FizzBuzzViewState())

    private var state: FizzBuzzViewState
        get() = _stateStream.value
        set(newState) {
            _stateStream.update { newState }
        }


    fun getFizzBuzzList(int1: Int, int2: Int, limit: Int, str1: String, str2: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getFizzBuzzList(int1, int2, limit, str1, str2).collectLatest {
                state = try {
                    state.copy(fizzBuzzList = it)
                } catch (e: Exception) {
                    state.copy(error = e.message.toString())
                }
            }
        }
    }

    fun getViewState(): StateFlow<FizzBuzzViewState> = _stateStream.asStateFlow()
}
