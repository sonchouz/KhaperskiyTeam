package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    role: UserRole,
    onNavigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text("KHAPERSKIY TEAM", color = TeamRed)

        Spacer(Modifier.height(20.dp))

        ScreenTitle("Твоя команда. Твой путь.")

        Text(
            "Команда бразильского джиу-джитсу",
            color = Gray
        )

        Spacer(Modifier.height(24.dp))

        TeamCard {
            Text("О команде", color = White)
            Spacer(Modifier.height(8.dp))
            Text(
                "Khaperskiy Team объединяет спортсменов, " +
                        "которые развиваются и достигают новых побед.",
                color = Gray
            )
            Spacer(Modifier.height(12.dp))
            Text("30+ спортсменов", color = TeamRed)
            Text("Тренер: Антон Хаперский", color = White)
        }

        Spacer(Modifier.height(24.dp))

        ScreenTitle("Ближайшие тренировки")

        DemoData.trainings.take(2).forEach { training ->
            Spacer(Modifier.height(12.dp))
            TeamCard {
                Text(training.title, color = TeamRed)
                Text(training.date, color = White)
                Text(training.time, color = White)
                Text("Тренер: ${training.coach}", color = Gray)
                Text(
                    "Свободно мест: ${training.availablePlaces}",
                    color = Gray
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        TeamButton(
            "Открыть расписание",
            onClick = { onNavigate(Routes.SCHEDULE) }
        )

        Spacer(Modifier.height(20.dp))

        val menu = listOf(
            "Группы" to Routes.GROUPS,
            "Абонементы" to Routes.MEMBERSHIPS,
            "Спортсмены" to Routes.ATHLETES,
            "Мероприятия" to Routes.EVENTS,
            "Профиль" to Routes.PROFILE
        )

        menu.forEach { (title, route) ->
            TextButton(
                onClick = { onNavigate(route) }
            ) {
                Text(title, color = White)
            }
        }

        if (role == UserRole.COACH) {
            TeamButton("Панель тренера") {
                onNavigate(Routes.TRAINER)
            }
        }

        if (role == UserRole.ADMIN) {
            TeamButton("Панель администратора") {
                onNavigate(Routes.ADMIN)
            }
        }
    }
}