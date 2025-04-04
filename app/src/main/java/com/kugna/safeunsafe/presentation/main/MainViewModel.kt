package com.kugna.safeunsafe.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kugna.safeunsafe.data.repository.TripRepository
import com.kugna.safeunsafe.data.model.MetricType
import com.kugna.safeunsafe.data.model.Trip
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val isLoading: Boolean = false,
    val isLoadingRecommendation: Boolean = false,
    val trips: List<Trip> = emptyList(),
    val error: String? = null,
    val totalMiles: Int = 0,
    val averageScores: Map<String, Int> = emptyMap(),
    val recommendation: String = "Start your journey by adding some trips!"
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tripRepository: TripRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        loadTrips()
        generateRecommendation()
    }

    private fun loadTrips() {
        tripRepository.getTrips()
            .onEach { trips ->
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        trips = trips,
                        totalMiles = calculateTotalMiles(trips),
                        averageScores = calculateAverageScores(trips)
                    )
                }
            }
            .catch { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An unexpected error occurred"
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun generateRecommendation() {
        viewModelScope.launch {
                _uiState.update { it.copy(isLoading = true) }
            try {
                val recommendation = tripRepository.generateRecommendation(_uiState.value.trips)
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        recommendation = recommendation
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Failed to generate recommendation"
                    )
                }
            }
        }
    }

    fun addSafeTrip() {
        addTrip(isSafe = true)
    }

    fun addUnsafeTrip() {
        addTrip(isSafe = false)
    }

    private fun addTrip(isSafe: Boolean) {
        viewModelScope.launch {
            try {
                tripRepository.addTrip(Trip(isSafe = isSafe))
                generateRecommendation()
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        error = e.message ?: "Failed to add trip"
                    )
                }
            }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }

    private fun calculateTotalMiles(trips: List<Trip>): Int {
        //Place holder implementation just to demo
        return trips.size * 8
    }

    private fun calculateAverageScores(trips: List<Trip>): Map<String, Int> {
        if (trips.isEmpty()) return emptyMap()

        return MetricType.entries.associate { metricType ->
            val scores = trips.flatMap { trip ->
                trip.metrics.filter { it.type == metricType }
            }.map { it.score }

            metricType.name to (scores.average().toInt())
        }
    }
}
