package com.kugna.safeunsafe.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.stringResource
import com.kugna.safeunsafe.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kugna.safeunsafe.presentation.main.MainUiState
import com.kugna.safeunsafe.ui.theme.CustomIcons

@Composable
fun MainScreen(
    uiState: MainUiState,
    onSafeTripClick: () -> Unit,
    onUnsafeTripClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.title_scorecard),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            ScoreCardSection(uiState)

            Spacer(modifier = Modifier.height(16.dp))

            RecommendationCard(
                recommendation = uiState.recommendation,
                isLoading = uiState.isLoadingRecommendation
            )

            Spacer(modifier = Modifier.weight(1f))

            TripActionButtons(
                onSafeTripClick = onSafeTripClick,
                onUnsafeTripClick = onUnsafeTripClick
            )
        }
    }
}

@Composable
fun RecommendationCard(
    recommendation: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.text_generating_recommendation),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 14.sp
                    )
                }
            } else {
                Column {
                    val (title, content) = recommendation.split(". ").let { parts ->
                        if (parts.size > 1) {
                            parts[0] to parts.drop(1).joinToString(". ")
                        } else {
                            stringResource(R.string.title_driving_analysis) to parts[0]
                        }
                    }

                    Text(
                        text = "$title.",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = content,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun TripActionButtons(
    onSafeTripClick: () -> Unit,
    onUnsafeTripClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onSafeTripClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50)
            )
        ) {
            Text(
                text = stringResource(R.string.button_add_safe_trip),
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = onUnsafeTripClick,
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF44336)
            )
        ) {
            Text(
                text = stringResource(R.string.button_add_unsafe_trip),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ScoreCardSection(uiState: MainUiState) {
    val drivingScores = uiState.averageScores.map { (type, score) ->
        val (label, icon) = when (type) {
            "BRAKING" -> stringResource(R.string.label_braking) to CustomIcons.Brightness_alert
            "ACCELERATION" -> stringResource(R.string.label_acceleration) to CustomIcons.Timer_play
            "SPEED" -> stringResource(R.string.label_speed) to CustomIcons.Speed
            "CORNERING" -> stringResource(R.string.label_cornering) to CustomIcons.Car_crash
            "PHONE_DISTRACTION" -> stringResource(R.string.label_phone_distraction) to CustomIcons.Phonelink_ring
            else -> type to CustomIcons.Directions
        }
        ScoreMetric(label, score, icon)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = CustomIcons.Directions,
                    contentDescription = stringResource(R.string.content_description_tips_icon),
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "${uiState.trips.size}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = stringResource(R.string.label_trips),
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "${uiState.totalMiles}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = stringResource(R.string.label_miles),
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                drivingScores.forEach { metric ->
                    ScoreItem(metric = metric)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.text_learn_more),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        //TODO
                    }
                    .padding(vertical = 12.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ScoreItem(metric: ScoreMetric) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = metric.icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = metric.label,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            ScoreProgressBar(score = metric.score)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "${metric.score}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = when {
                metric.score >= 80 -> Color(0xFF4CAF50)
                metric.score >= 60 -> Color(0xFFFFA000)
                else -> Color(0xFFF44336)
            }
        )

        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun ScoreProgressBar(score: Int) {
    val progressColor = when {
        score >= 80 -> Color(0xFF4CAF50)
        score >= 60 -> Color(0xFFFFA000)
        else -> Color(0xFFF44336)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFFE0E0E0))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(score / 100f)
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(progressColor)
        )
    }
}
