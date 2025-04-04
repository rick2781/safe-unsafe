package com.kugna.safeunsafe.data.repository

import com.kugna.safeunsafe.data.model.Trip
import com.kugna.safeunsafe.data.service.AIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripRepositoryImpl @Inject constructor(
    private val aiService: AIService
) : TripRepository {
    private val trips = MutableStateFlow<List<Trip>>(emptyList())

    override fun getTrips(): Flow<List<Trip>> = trips.asStateFlow()

    override suspend fun addTrip(trip: Trip) {
        val metrics = aiService.generateTripMetrics(trip.isSafe)
        val updatedTrip = trip.copy(
            id = UUID.randomUUID().toString(),
            metrics = metrics
        )
        trips.value += updatedTrip
    }

    override suspend fun generateRecommendation(trips: List<Trip>): String {
        return aiService.generateRecommendation(trips)
    }
}
