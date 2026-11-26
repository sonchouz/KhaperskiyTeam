package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun MembershipsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Абонементы")

        Text(
            "Выбери подходящий формат тренировок",
            color = Gray
        )

        Spacer(Modifier.height(20.dp))

        DemoData.memberships.forEach { item ->
            TeamCard(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    item.name.uppercase(),
                    color = TeamRed
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    if (item.sessions == 0) "Безлимит"
                    else "${item.sessions} занятий",
                    color = White
                )

                Text(item.duration, color = Gray)

                Spacer(Modifier.height(12.dp))

                Text(
                    "${item.price} ₽",
                    style = MaterialTheme.typography.headlineMedium,
                    color = White
                )

                Text(item.description, color = Gray)
            }
        }
    }
}