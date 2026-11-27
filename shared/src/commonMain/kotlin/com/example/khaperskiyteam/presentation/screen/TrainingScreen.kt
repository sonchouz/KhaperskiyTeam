package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Расписание")

        Spacer(Modifier.height(20.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(DemoData.trainings) { training ->
                TeamCard {
                    Text(training.date, color = Gray)
                    Text(training.title, color = TeamRed)
                    Text(training.time, color = White)
                    Text("Группа: ${training.group}", color = White)
                    Text("Тренер: ${training.coach}", color = Gray)
                    Text(
                        "Свободных мест: ${training.availablePlaces}",
                        color = Gray
                    )
                }
            }
        }
    }
}

@Composable
fun GroupsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Тренировочные группы")

        Spacer(Modifier.height(20.dp))

        DemoData.groups.forEach { group ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(group.name, color = White)
                Text("Тренер: ${group.coach}", color = Gray)
                Text("Возраст: ${group.age}", color = Gray)
                Text(group.schedule, color = Gray)

                Spacer(Modifier.height(8.dp))

                Text(
                    "Свободно ${group.availablePlaces} из ${group.totalPlaces}",
                    color = TeamRed
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = TeamRed
                    )
                ) {
                    Text("Выбрать группу")
                }
            }
        }
    }
}