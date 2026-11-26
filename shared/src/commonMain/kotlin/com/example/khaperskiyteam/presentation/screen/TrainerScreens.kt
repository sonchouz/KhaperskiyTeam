package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun TrainerScreen(
    onNavigate: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Панель тренера")

        Text("Антон Хаперский", color = Gray)

        Spacer(Modifier.height(24.dp))

        TeamCard {
            Text("Мои тренировки", color = White)
            Text("3 занятия на этой неделе", color = TeamRed)
        }

        Spacer(Modifier.height(16.dp))

        TeamButton("Моё расписание") {
            onNavigate(Routes.TRAINER_SCHEDULE)
        }

        Spacer(Modifier.height(12.dp))

        TeamButton("Записи спортсменов") {
            onNavigate(Routes.ATHLETE_BOOKINGS)
        }
    }
}

@Composable
fun TrainerScheduleScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Мои тренировки")

        Spacer(Modifier.height(16.dp))

        DemoData.trainings.forEach { training ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(training.title, color = TeamRed)
                Text(training.date, color = White)
                Text(training.time, color = Gray)

                TextButton(
                    onClick = {}
                ) {
                    Text("Изменить тренировку", color = TeamRed)
                }
            }
        }
    }
}

@Composable
fun EditTrainingScreen() {
    var date by remember { mutableStateOf("23.11.2026") }
    var time by remember { mutableStateOf("16:00–18:00") }
    var group by remember { mutableStateOf("Соревновательная") }

    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Изменение тренировки")

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            date,
            { date = it },
            label = { Text("Дата") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            time,
            { time = it },
            label = { Text("Время") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            group,
            { group = it },
            label = { Text("Группа") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        TeamButton("Сохранить изменения") {
            // Здесь будет обновление через Supabase
        }
    }
}

@Composable
fun AthleteBookingsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Записи спортсменов")

        Spacer(Modifier.height(16.dp))

        DemoData.athletes.forEach { athlete ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(athlete.fullName, color = White)
                Text(athlete.belt, color = Gray)

                var confirmed by remember {
                    mutableStateOf(false)
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        if (confirmed) "Подтверждено"
                        else "Ожидает подтверждения",
                        color = if (confirmed) Success else Gray
                    )

                    Switch(
                        checked = confirmed,
                        onCheckedChange = { confirmed = it }
                    )
                }
            }
        }
    }
}