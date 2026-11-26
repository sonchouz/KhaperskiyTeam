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
fun AdminScreen(
    onNavigate: (String) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Администрирование")

        Spacer(Modifier.height(20.dp))

        TeamCard {
            Text("Статистика команды", color = White)
            Text("30+ спортсменов", color = TeamRed)
            Text("3 тренировочные группы", color = Gray)
            Text("3 тренировки в расписании", color = Gray)
        }

        Spacer(Modifier.height(16.dp))

        TeamButton("Пользователи") {
            onNavigate(Routes.ADMIN_USERS)
        }

        Spacer(Modifier.height(12.dp))

        TeamButton("Тренировочные группы") {
            onNavigate(Routes.ADMIN_GROUPS)
        }
    }
}

@Composable
fun AdminUsersScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Пользователи")

        Spacer(Modifier.height(16.dp))

        DemoData.athletes.forEach { athlete ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(athlete.fullName, color = White)
                Text(athlete.belt, color = Gray)
                Text("Спортсмен", color = TeamRed)
            }
        }
    }
}

@Composable
fun AdminGroupsScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Управление группами")

        Spacer(Modifier.height(16.dp))

        DemoData.groups.forEach { group ->
            TeamCard(
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(group.name, color = White)
                Text("Тренер: ${group.coach}", color = Gray)
               
            }
        }
    }
}