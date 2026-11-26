package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun TrainingCard(
    date: String,
    time: String,
    title: String,
    coach: String,
    group: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    KTCard(
        modifier = modifier,
        contentPadding = 16.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = date,
                color = KTColors.TextSecondary,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = group,
                color = KTColors.Red,
                style = MaterialTheme.typography.labelMedium
            )
        }

        Spacer(Modifier.height(12.dp))

        Text(
            text = time,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Тренер: $coach",
            color = KTColors.TextSecondary,
            style = MaterialTheme.typography.bodySmall
        )
    }
}