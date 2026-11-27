package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun AthletesScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Спортсмены")

        Spacer(Modifier.height(16.dp))

        DemoData.athletes.forEach { athlete ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(athlete.fullName, color = White)
                Text("${athlete.age} лет", color = Gray)
                Text(athlete.belt, color = Gray)
                Text(
                    "🏅 ${athlete.medals} медали",
                    color = TeamRed
                )
            }
        }
    }
}

@Composable
fun EventsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Мероприятия")

        Spacer(Modifier.height(16.dp))

        DemoData.events.forEach { event ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(event.category.uppercase(), color = TeamRed)
                Text(event.title, color = White)
                Text(event.date, color = Gray)
                Text(event.location, color = Gray)
                Text(event.description, color = White)
            }
        }
    }
}