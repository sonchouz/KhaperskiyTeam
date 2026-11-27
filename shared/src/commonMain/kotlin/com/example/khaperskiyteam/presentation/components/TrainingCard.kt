package com.example.khaperskiyteam.presentation.components.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.*
import com.example.khaperskiyteam.presentation.theme.*

@Composable
fun TrainingCard(
    date: String,
    time: String,
    title: String,
    coach: String,
    places: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    KTCard(
        modifier = modifier,
        backgroundColor = KTColors.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = date.uppercase(),
                color = KTColors.Primary,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = places,
                color = KTColors.Black,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = time,
                color = KTColors.Black,
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = title,
                color = KTColors.Black
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Тренер: $coach",
            color = KTColors.Muted,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(Modifier.height(16.dp))

        KTPrimaryButton(
            text = "Подробнее",
            onClick = onClick
        )
    }
}