package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
fun ProfileScreen() {
    var editing by remember { mutableStateOf(false) }

    var firstName by remember {
        mutableStateOf("Александр")
    }

    var lastName by remember {
        mutableStateOf("Смирнов")
    }

    var phone by remember {
        mutableStateOf("+7 999 123-45-67")
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Background)
            .padding(20.dp)
    ) {
        ScreenTitle("Мой профиль")

        Spacer(Modifier.height(24.dp))

        TeamCard {
            Text(
                "$firstName $lastName",
                style = MaterialTheme.typography.titleLarge,
                color = White
            )
            Text("Коричневый пояс", color = TeamRed)
            Text("Соревновательная группа", color = Gray)
        }

        Spacer(Modifier.height(20.dp))

        if (editing) {
            OutlinedTextField(
                firstName,
                { firstName = it },
                label = { Text("Имя") }
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                lastName,
                { lastName = it },
                label = { Text("Фамилия") }
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                phone,
                { phone = it },
                label = { Text("Телефон") }
            )

            Spacer(Modifier.height(16.dp))

            TeamButton("Сохранить") {
                editing = false
            }
        } else {
            Text("Телефон: $phone", color = Gray)

            Spacer(Modifier.height(16.dp))

            TeamButton("Редактировать профиль") {
                editing = true
            }
        }
    }
}