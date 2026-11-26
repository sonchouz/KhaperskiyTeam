package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun GroupCard(
    name: String,
    ageCategory: String,
    coach: String,
    schedule: String,
    modifier: Modifier = Modifier
) {
    KTCard(
        modifier = modifier,
        contentPadding = 16.dp
    ) {
        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = ageCategory,
            color = KTColors.Red,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "Тренер: $coach",
            color = KTColors.TextSecondary
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = schedule,
            color = Color.White
        )


    }
}