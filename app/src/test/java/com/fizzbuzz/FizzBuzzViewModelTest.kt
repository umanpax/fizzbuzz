package com.fizzbuzz

import com.fizzbuzz.features.fizzbuzz.services.FizzBuzzRepository
import com.fizzbuzz.features.fizzbuzz.states.FizzBuzzViewState
import com.fizzbuzz.features.fizzbuzz.viewmodels.FizzBuzzViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


@ExperimentalCoroutinesApi
class FizzBuzzViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var state: FizzBuzzViewState

    private lateinit var viewModel: FizzBuzzViewModel
    private lateinit var repository: FizzBuzzRepository

    @Before
    fun setUp() {
        state = Mockito.mock(FizzBuzzViewState::class.java)
        repository = Mockito.mock(FizzBuzzRepository::class.java)
        viewModel = FizzBuzzViewModel(repository)
    }

    @Test
    fun testGetFizzBuzzList() = coroutineTestRule.testScope.runBlockingTest {

        val mockResponse = listOf(
            "1 --------> Fizz",
            "2 --------> Buzz",
            "3 --------> Fizz"
        )

        Mockito.`when`(repository.getFizzBuzzList(3, 5, 100, "Fizz", "Buzz"))
            .thenReturn(flowOf(mockResponse))

        coroutineTestRule.run {
            viewModel.getFizzBuzzList(3, 5, 100, "Fizz", "Buzz").runCatching {
                val currentState = viewModel.getViewState().value
                assert(currentState.error.isEmpty())
                assert(currentState.fizzBuzzList.isNotEmpty())
                assert(currentState.fizzBuzzList == mockResponse)
            }

        }
    }
}
