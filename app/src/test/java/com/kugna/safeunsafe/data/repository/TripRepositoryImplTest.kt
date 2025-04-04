package com.kugna.safeunsafe.data.repository

import com.kugna.safeunsafe.data.model.MetricType
import com.kugna.safeunsafe.data.model.TripMetric
import com.kugna.safeunsafe.data.model.Trip
import com.kugna.safeunsafe.data.service.AIService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TripRepositoryImplTest {
    private lateinit var repository: TripRepositoryImpl
    private lateinit var aiService: AIService

    @Before
    fun setup() {
        aiService = mockk()
        repository = TripRepositoryImpl(aiService)
    }

    @Test
    fun `initial trips list is empty`() = runTest {
        val trips = repository.getTrips().first()
        assertEquals(emptyList<Trip>(), trips)
    }

    @Test
    fun `adding trip generates metrics and updates flow`() = runTest {
        // Given
        val trip = Trip(isSafe = true)
        val metrics = listOf(
            TripMetric(type = MetricType.SPEED, score = 85),
            TripMetric(type = MetricType.BRAKING, score = 90)
        )
        coEvery { aiService.generateTripMetrics(true) } returns metrics

        // When
        repository.addTrip(trip)

        // Then
        val trips = repository.getTrips().first()
        assertEquals(1, trips.size)
        with(trips.first()) {
            assertNotNull(id)
            assertEquals(true, isSafe)
            assertEquals(metrics, this.metrics)
        }
        coVerify { aiService.generateTripMetrics(true) }
    }

    @Test
    fun `generate recommendation delegates to AI service`() = runTest {
        // Given
        val trips = listOf(Trip(isSafe = true))
        val expectedRecommendation = "Drive safely!"
        coEvery { aiService.generateRecommendation(trips) } returns expectedRecommendation

        // When
        val recommendation = repository.generateRecommendation(trips)

        // Then
        assertEquals(expectedRecommendation, recommendation)
        coVerify { aiService.generateRecommendation(trips) }
    }
}
