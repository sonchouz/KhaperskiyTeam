package com.example.khaperskiyteam.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.KTCard
import com.example.khaperskiyteam.presentation.components.KTChip
import com.example.khaperskiyteam.presentation.components.KTDivider
import com.example.khaperskiyteam.presentation.components.KTOutlinedButton
import com.example.khaperskiyteam.presentation.components.KTPrimaryButton
import com.example.khaperskiyteam.presentation.components.KTSectionTitle
import com.example.khaperskiyteam.presentation.components.KTTextButton
import com.example.khaperskiyteam.presentation.components.KTTextField
import com.example.khaperskiyteam.presentation.theme.KTColors
import com.example.khaperskiyteam.presentation.theme.KTDimens
import com.example.khaperskiyteam.presentation.theme.KhaperskiyTheme


@Composable
fun DesignSystemPreview() {

    var name by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf("Все") }

    KhaperskiyTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(KTDimens.ScreenPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Заголовок
            Text(
                text = "Khaperskiy Team",
                style = MaterialTheme.typography.headlineLarge,
                color = KTColors.White
            )

            Text(
                text = "Дизайн-система приложения",
                style = MaterialTheme.typography.bodyMedium,
                color = KTColors.TextSecondary
            )

            KTDivider()

            // Кнопки
            KTSectionTitle("Кнопки")

            KTPrimaryButton(
                text = "Основная кнопка",
                onClick = {}
            )

            KTOutlinedButton(
                text = "Контурная кнопка",
                onClick = {}
            )

            KTTextButton(
                text = "Текстовая кнопка",
                onClick = {}
            )

            // Поле ввода
            KTSectionTitle("Поля ввода")

            KTTextField(
                value = name,
                onValueChange = { name = it },
                label = "Имя спортсмена",
                placeholder = "Введите имя"
            )

            // Фильтры
            KTSectionTitle("Фильтры")

            androidx.compose.foundation.layout.Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Все", "BJJ", "No-Gi").forEach { item ->

                    KTChip(
                        text = item,
                        selected = selected == item,
                        onClick = { selected = item }
                    )
                }
            }

            // Карточка
            KTSectionTitle("Карточки")

            KTCard {
                Text(
                    text = "Антон Хаперский",
                    style = MaterialTheme.typography.titleLarge,
                    color = KTColors.White
                )

                Text(
                    text = "Тренер • BJJ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = KTColors.TextSecondary
                )
            }
        }
    }
}
