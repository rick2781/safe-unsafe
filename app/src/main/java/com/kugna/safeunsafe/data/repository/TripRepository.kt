package com.kugna.safeunsafe.data.repository

import com.kugna.safeunsafe.data.model.Trip
import kotlinx.coroutines.flow.Flow

interface TripRepository {
    fun getTrips(): Flow<List<Trip>>
    suspend fun addTrip(trip: Trip)
    suspend fun generateRecommendation(trips: List<Trip>): String
}
