package com.kugna.safeunsafe.presentation.main

import com.kugna.safeunsafe.data.model.MetricType
import com.kugna.safeunsafe.data.model.Trip
import com.kugna.safeunsafe.data.repository.TripRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: TripRepository
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk(relaxed = true)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is correct`() = runTest {
        // Given
        coEvery { repository.getTrips() } returns flowOf(emptyList())
        coEvery { repository.generateRecommendation(any()) } returns "Start your journey by adding some trips!"
        
        // When
        viewModel = MainViewModel(repository)
        
        // Then
        with(viewModel.uiState.value) {
            assertEquals(false, isLoading)
            assertEquals(emptyList<Trip>(), trips)
            assertEquals(0, totalMiles)
            assertEquals("Start your journey by adding some trips!", recommendation)
            assertEquals(null, error)
        }
    }

    @Test
    fun `loading trips updates state correctly`() = runTest {
        // Given
        val trips = listOf(
            Trip(isSafe = true),
            Trip(isSafe = false)
        )
        coEvery { repository.getTrips() } returns flowOf(trips)
        coEvery { repository.generateRecommendation(any()) } returns "Test recommendation"
        
        // When
        viewModel = MainViewModel(repository)
        
        // Then
        with(viewModel.uiState.value) {
            assertEquals(false, isLoading)
            assertEquals(trips, this.trips)
            assertEquals(16, totalMiles) // 2 trips * 8 miles
            assertEquals("Test recommendation", recommendation)
        }
    }

    @Test
    fun `adding safe trip calls repository`() = runTest {
        // Given
        viewModel = MainViewModel(repository)
        
        // When
        viewModel.addSafeTrip()
        
        // Then
        coVerify { repository.addTrip(match { it.isSafe }) }
    }

    @Test
    fun `adding unsafe trip calls repository`() = runTest {
        // Given
        viewModel = MainViewModel(repository)
        
        // When
        viewModel.addUnsafeTrip()
        
        // Then
        coVerify { repository.addTrip(match { !it.isSafe }) }
    }

    @Test
    fun `repository error updates error state`() = runTest {
        // Given
        val errorMessage = "Test error"
        coEvery { repository.getTrips() } returns flowOf(emptyList())
        coEvery { repository.generateRecommendation(any()) } throws Exception(errorMessage)
        
        // When
        viewModel = MainViewModel(repository)
        
        // Then
        with(viewModel.uiState.value) {
            assertEquals(false, isLoading)
            assertEquals(errorMessage, error)
        }
    }

    @Test
    fun `clear error updates state`() = runTest {
        // Given
        val errorMessage = "Test error"
        coEvery { repository.getTrips() } returns flowOf(emptyList())
        coEvery { repository.generateRecommendation(any()) } throws Exception(errorMessage)
        viewModel = MainViewModel(repository)
        
        // When
        viewModel.clearError()
        
        // Then
        with(viewModel.uiState.value) {
            assertEquals(false, isLoading)
            assertEquals(null, error)
        }
    }

    @Test
    fun `recommendation error updates error state`() = runTest {
        // Given
        val errorMessage = "Recommendation error"
        coEvery { repository.getTrips() } returns flowOf(emptyList())
        coEvery { repository.generateRecommendation(any()) } throws Exception(errorMessage)
        
        // When
        viewModel = MainViewModel(repository)
        
        // Then
        assertEquals(errorMessage, viewModel.uiState.value.error)
    }
}
