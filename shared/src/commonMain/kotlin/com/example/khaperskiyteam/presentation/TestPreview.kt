package com.example.khaperskiyteam.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.*
import com.example.khaperskiyteam.presentation.components.cards.*
import com.example.khaperskiyteam.presentation.theme.*
import khaperskiyteam.shared.generated.resources.Res
import khaperskiyteam.shared.generated.resources.background
import khaperskiyteam.shared.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Preview
@Composable
fun DesignSystemPreview() {
    KhaperskiyTheme {

        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("password123") }
        var selectedTab by remember { mutableStateOf(0) }
        var selectedFilter by remember { mutableStateOf("Все") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(KTColors.Background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "KHAPERSKIY TEAM",
                color = KTColors.Primary,
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Design System",
                color = KTColors.White,
                style = MaterialTheme.typography.titleLarge
            )

            // ========================================
            // 1. ЦВЕТОВАЯ ПАЛИТРА
            // ========================================

            Text(
                text = "01. Цветовая палитра",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            val colors = listOf(
                "Primary" to KTColors.Primary,
                "PrimaryDark" to KTColors.PrimaryDark,
                "Background" to KTColors.Background,
                "Surface" to KTColors.Surface,
                "White" to KTColors.White,
                "Black" to KTColors.Black,
                "LightGray" to KTColors.LightGray,
                "Muted" to KTColors.Muted,
                "Border" to KTColors.Border,
                "Success" to KTColors.Success,
                "Error" to KTColors.Error,
                "Card" to KTColors.Card
            )

            colors.chunked(3).forEach { colorRow ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    colorRow.forEach { (name, color) ->
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(color)
                            )

                            Text(
                                text = name,
                                color = KTColors.White,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 2. ТИПОГРАФИКА
            // ========================================

            Text(
                text = "02. Типографика",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            val typography = MaterialTheme.typography

            val textStyles = listOf(
                "Headline Large" to typography.headlineLarge,
                "Headline Medium" to typography.headlineMedium,
                "Title Large" to typography.titleLarge,
                "Title Medium" to typography.titleMedium,
                "Title Small" to typography.titleSmall,
                "Body Large" to typography.bodyLarge,
                "Body Medium" to typography.bodyMedium,
                "Body Small" to typography.bodySmall,
                "Label Large" to typography.labelLarge,
                "Label Medium" to typography.labelMedium,
                "Label Small" to typography.labelSmall
            )

            textStyles.forEach { (name, style) ->
                Text(
                    text = name,
                    style = style,
                    color = KTColors.White
                )
            }

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 3. КНОПКИ
            // ========================================

            Text(
                text = "03. Кнопки",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

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
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            KTPrimaryButton(
                text = "Неактивная кнопка",
                enabled = false,
                onClick = {}
            )

            KTOutlinedButton(
                text = "Неактивная контурная кнопка",
                enabled = false,
                onClick = {}
            )

            KTTextButton(
                text = "Неактивная текстовая кнопка",
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 4. ПОЛЯ ВВОДА
            // ========================================

            Text(
                text = "04. Поля ввода",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            KTTextField(
                value = login,
                onValueChange = { login = it },
                placeholder = "Введите логин",
                label = "Пустое поле"
            )

            KTTextField(
                value = "bjj_lover",
                onValueChange = {},
                placeholder = "Введите логин",
                label = "Заполненное поле"
            )

            KTPasswordField(
                value = password,
                onValueChange = { password = it },
                label = "Пароль"
            )

            KTTextField(
                value = "12345",
                onValueChange = {},
                placeholder = "Введите пароль",
                label = "Поле с ошибкой",
                isError = true,
                errorMessage = "Минимум 8 символов"
            )

            KTTextField(
                value = "Недоступно",
                onValueChange = {},
                placeholder = "",
                label = "Неактивное поле",
                enabled = false
            )

            // Светлые поля ввода

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(KTColors.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Светлые поля ввода",
                    color = KTColors.Black,
                    style = MaterialTheme.typography.titleMedium
                )

                KTTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = "Введите имя",
                    label = "Имя",
                    light = true
                )

                KTTextField(
                    value = "Иванов",
                    onValueChange = {},
                    placeholder = "Введите фамилию",
                    label = "Фамилия",
                    light = true
                )

                KTPasswordField(
                    value = password,
                    onValueChange = { password = it },
                    light = true
                )
            }

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 5. БАЗОВАЯ КАРТОЧКА
            // ========================================

            Text(
                text = "05. Базовая карточка",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            KTCard {
                Text(
                    text = "Заголовок карточки",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Содержимое карточки",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 6. КАРТОЧКА ТРЕНИРОВКИ
            // ========================================

            Text(
                text = "06. TrainingCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            TrainingCard(
                date = "Понедельник",
                time = "19:00–20:30",
                title = "GI 18+",
                coach = "Антон Хаперский",
                places = "12/16",
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 7. КАРТОЧКА СПОРТСМЕНА
            // ========================================

            Text(
                text = "07. AthleteCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            AthleteCard(
                name = "Никоноров Михаил",
                belt = "Жёлто-чёрный пояс",
                medals = 20,
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 8. КАРТОЧКА ГРУППЫ
            // ========================================

            Text(
                text = "08. GroupCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            GroupCard(
                name = "Соревновательная группа",
                schedule = "Пн, Ср, Пт 16:00–18:00",
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 9. КАРТОЧКА АБОНЕМЕНТА
            // ========================================

            Text(
                text = "09. MembershipCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            MembershipCard(
                name = "Разовое\nзанятие",
                price = "600 руб.",
                background = painterResource(Res.drawable.background),
                logo = painterResource(
                    Res.drawable.logo
                ),
                onClick = {}
            )

            MembershipCard(
                name = "Абонемент\n4 занятия",
                price = "4000 руб.",
                background = painterResource(
                    Res.drawable.background
                ),
                logo = painterResource(
                    Res.drawable.logo
                ),
                onClick = {}
            )

            MembershipCard(
                name = "Абонемент\n8 занятий",
                price = "5000 руб.",
                background = painterResource(
                    Res.drawable.background
                ),
                logo = painterResource(
                    Res.drawable.logo
                ),
                onClick = {}
            )

            MembershipCard(
                name = "Абонемент\n12 занятий",
                price = "6000 руб.",
                background = painterResource(
                    Res.drawable.background
                ),
                logo = painterResource(
                    Res.drawable.logo
                ),
                onClick = {}
            )

            MembershipCard(
                name = "Персональная\nтренировка",
                price = "1500 руб.",
                background = painterResource(
                    Res.drawable.background
                ),
                logo = painterResource(
                    Res.drawable.logo
                ),
                onClick = {}
            )
            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 10. КАРТОЧКА МЕРОПРИЯТИЯ
            // ========================================

            Text(
                text = "10. EventCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            EventCard(
                name = "Siberian Open Cup 2026",
                date = "07–08 ноября 2026",
                address = "Новосибирск, ул. Фабричная, 17/4",
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 11. КАРТОЧКА ПРОФИЛЯ
            // ========================================

            Text(
                text = "11. ProfileCard",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            ProfileCard(
                fullName = "Никоноров Михаил",
                role = "Спортсмен",
                belt = "Жёлто-чёрный пояс",
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 12. ФИЛЬТРЫ
            // ========================================

            Text(
                text = "12. KTChip",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Все", "Турниры", "Сборы").forEach { filter ->
                    KTChip(
                        text = filter,
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 13. МЕНЮ ПРОФИЛЯ
            // ========================================

            Text(
                text = "13. ProfileMenuItem",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            ProfileMenuItem(
                title = "Моя группа",
                subtitle = "Соревновательная группа",
                onClick = {}
            )

            ProfileMenuItem(
                title = "Мои записи",
                subtitle = "Ближайшая тренировка: 19 ноя, 14:30",
                onClick = {}
            )

            ProfileMenuItem(
                title = "Личные данные",
                onClick = {}
            )

            ProfileMenuItem(
                title = "Редактировать профиль",
                onClick = {}
            )

            ProfileMenuItem(
                title = "Выйти из аккаунта",
                isDestructive = true,
                onClick = {}
            )

            HorizontalDivider(color = KTColors.Border)

            // ========================================
            // 14. НИЖНЯЯ НАВИГАЦИЯ
            // ========================================

            Text(
                text = "14. KTBottomNavigation",
                color = KTColors.Primary,
                style = MaterialTheme.typography.titleLarge
            )

            KTBottomNavigation(
                selected = selectedTab,
                onSelect = { selectedTab = it }
            )

            Text(
                text = "Все состояния навигации",
                color = KTColors.Muted,
                style = MaterialTheme.typography.bodyMedium
            )

            repeat(5) { index ->
                KTBottomNavigation(
                    selected = index,
                    onSelect = {}
                )
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}