package com.kugna.safeunsafe.data.model

data class Trip(
    val id: String = "",
    val isSafe: Boolean,
    val metrics: List<TripMetric> = emptyList()
)

data class TripMetric(
    val type: MetricType,
    val score: Int
)

enum class MetricType {
    BRAKING,
    ACCELERATION,
    SPEED,
    CORNERING,
    PHONE_DISTRACTION
}
