package com.kugna.safeunsafe.data.service

import android.content.Context
import com.google.ai.edge.aicore.GenerativeModel
import com.google.ai.edge.aicore.generationConfig
import com.kugna.safeunsafe.data.model.MetricType
import com.kugna.safeunsafe.data.model.Trip
import com.kugna.safeunsafe.data.model.TripMetric
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class AIService @Inject constructor(
    @ApplicationContext private val aiContext: Context
) {
    private val model = GenerativeModel(
        generationConfig {
            context = aiContext
            temperature = 0.2f
            topK = 15
            maxOutputTokens = 256
        }
    )

    suspend fun generateTripMetrics(isSafe: Boolean): List<TripMetric> =
        withContext(Dispatchers.Default) {
            val scoreRange = if (isSafe) 70..100 else 30..60

            val prompt = buildString {
                append("Generate driving scores for a ${if (isSafe) "safe" else "unsafe"} trip. ")
                append("For each metric, provide a score between ${scoreRange.first} and ${scoreRange.last}. ")
                append("Format the response as 'Metric: Score' for each of these metrics:\n")
                MetricType.entries.forEach { metricType ->
                    append("${metricType.name.lowercase()}\n")
                }
            }

            try {
                val response = model.generateContent(prompt).text ?: ""
                val scores = MetricType.entries.associateWith { metricType ->
                    val regex =
                        "${metricType.name.lowercase()}:\\s*(\\d+)".toRegex(RegexOption.IGNORE_CASE)
                    val score = regex.find(response)?.groupValues?.get(1)?.toIntOrNull()
                        ?.coerceIn(scoreRange)
                        ?: Random.nextInt(scoreRange.first, scoreRange.last + 1)
                    score
                }

                MetricType.entries.map { metricType ->
                    TripMetric(metricType, scores[metricType]!!)
                }
            } catch (e: Exception) {
                // Fallback to random scores if AI fails / nt supported device
                MetricType.entries.map { metricType ->
                    TripMetric(metricType, Random.nextInt(scoreRange.first, scoreRange.last + 1))
                }
            }
        }

    suspend fun generateRecommendation(trips: List<Trip>): String =
        withContext(Dispatchers.Default) {
            if (trips.isEmpty()) return@withContext "Start your journey by adding some trips!"

            val recentTrips = trips.takeLast(5)
            val safeTrips = recentTrips.count { it.isSafe }
            val unsafeTrips = recentTrips.size - safeTrips

            val lowestScores = recentTrips
                .flatMap { it.metrics }
                .groupBy { it.type }
                .mapValues { (_, metrics) -> metrics.minOfOrNull { it.score } ?: 0 }

            val worstMetric = lowestScores.minByOrNull { it.value }?.key

            val prompt = buildString {
                append("Generate a short, encouraging driving recommendation based on: ")
                append("$safeTrips safe trips and $unsafeTrips unsafe trips in last 5 trips. ")
                if (worstMetric != null) {
                    append("The driver needs most improvement in ${worstMetric.name.lowercase()}.")
                }
            }

            try {
                model.generateContent(prompt).text
            } catch (e: Exception) {
                val title = when {
                    safeTrips > unsafeTrips -> "Great Progress"
                    safeTrips == unsafeTrips -> "Mixed Performance"
                    else -> "Room for Improvement"
                }

                val content = buildString {
                    when {
                        safeTrips > unsafeTrips -> append("You've completed ${safeTrips} safe trips recently. ")
                        safeTrips == unsafeTrips -> append("Your recent trips show equal safe and unsafe patterns. ")
                        else -> append("You've had ${unsafeTrips} unsafe trips recently. ")
                    }

                    if (worstMetric != null) {
                        append(
                            when (worstMetric) {
                                MetricType.BRAKING -> "Try to anticipate stops earlier for smoother braking."
                                MetricType.ACCELERATION -> "Practice gentler acceleration for better control."
                                MetricType.SPEED -> "Keep within speed limits for safer driving."
                                MetricType.CORNERING -> "Take corners slowly and steadily."
                                MetricType.PHONE_DISTRACTION -> "Remember to avoid phone distractions."
                            }
                        )
                    }
                }

                "$title. $content"
            }.toString()
        }
}
