package com.example.khaperskiyteam.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.AthleteCard
import com.example.khaperskiyteam.presentation.components.GroupCard
import com.example.khaperskiyteam.presentation.components.MembershipCard
import com.example.khaperskiyteam.presentation.components.TrainingCard
import com.example.khaperskiyteam.presentation.theme.KTColors
@Preview
@Composable
fun CardPreviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KTColors.Background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("ТРЕНИРОВКИ", color = KTColors.Red)

        TrainingCard(
            date = "ПОНЕДЕЛЬНИК, 26 НОЯБРЯ",
            time = "18:00 – 19:30",
            title = "Бразильское джиу-джитсу",
            coach = "Антон Хаперский",
            group = "GI"
        )

        Text("СПОРТСМЕНЫ", color = KTColors.Red)

        AthleteCard(
            fullName = "Иван Иванов",
            age = 19,
            belt = "Синий",
            medals = 5
        )

        Text("ТРЕНИРОВОЧНЫЕ ГРУППЫ", color = KTColors.Red)

        GroupCard(
            name = "Начальная группа",
            ageCategory = "От 14 лет",
            coach = "Антон Хаперский",
            schedule = "Пн, Ср, Пт • 18:00"
        )

        Text("АБОНЕМЕНТЫ", color = KTColors.Red)

        MembershipCard(
            name = "Стандарт",
            lessonsCount = 12,
            validity = "30 дней",
            price = "4 500 ₽"
        )
    }
}