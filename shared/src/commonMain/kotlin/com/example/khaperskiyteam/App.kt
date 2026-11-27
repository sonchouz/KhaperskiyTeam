package com.example.khaperskiyteam

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.*
import com.example.khaperskiyteam.presentation.components.cards.*
import com.example.khaperskiyteam.presentation.theme.*

@Composable
fun App() {
    KhaperskiyTheme {

        var selected by remember {
            mutableStateOf(0)
        }

        Scaffold(
            containerColor = KTColors.Background,
            bottomBar = {
                KTBottomNavigation(
                    selected = selected,
                    onSelect = { selected = it }
                )
            }
        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(KTDimens.ScreenPadding),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Text(
                    text = "KHAPERSKIY TEAM",
                    color = KTColors.Primary,
                    style = MaterialTheme.typography.titleLarge
                )

                when (selected) {
                    0 -> HomePreview()
                    1 -> MembershipsPreview()
                    2 -> AthletesPreview()
                    3 -> EventsPreview()
                    4 -> ProfilePreview()
                }
            }
        }
    }
}

@Composable
private fun HomePreview() {

    Text(
        text = "СИЛЬНЫЕ ЛЮДИ СОЗДАЮТ СИЛЬНОЕ ОКРУЖЕНИЕ",
        style = MaterialTheme.typography.headlineLarge
    )

    KTCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TeamStat("2", "года с вами")
            TeamStat("№1", "по технике")
            TeamStat("30", "спортсменов")
        }
    }

    Text(
        text = "Ближайшие тренировки",
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

    TrainingCard(
        date = "Среда",
        time = "16:00–18:00",
        title = "NO-GI",
        coach = "Антон Хаперский",
        places = "8/16",
        onClick = {}
    )

    Text(
        text = "Тренировочные группы",
        style = MaterialTheme.typography.titleLarge
    )

    GroupCard(
        name = "Соревновательная группа",
        schedule = "Пн, Ср, Пт 16:00–18:00",
        onClick = {}
    )
}

@Composable
private fun TeamStat(
    value: String,
    description: String
) {
    Column {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = description,
            color = KTColors.Muted,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun MembershipsPreview() {

    Text(
        text = "АБОНЕМЕНТЫ",
        style = MaterialTheme.typography.titleLarge
    )

    val memberships = listOf(
        "Разовое занятие" to "600 руб.",
        "Абонемент\n4 занятия" to "4000 руб.",
        "Абонемент\n8 занятий" to "5000 руб.",
        "Абонемент\n12 занятий" to "6000 руб.",
        "Персональная тренировка" to "1500 руб."
    )

    memberships.forEach { membership ->
        MembershipCard(
            name = membership.first,
            price = membership.second,
            onClick = {}
        )
    }
}

@Composable
private fun AthletesPreview() {

    var query by remember {
        mutableStateOf("")
    }

    Text(
        text = "СПОРТСМЕНЫ",
        style = MaterialTheme.typography.titleLarge
    )

    KTTextField(
        value = query,
        onValueChange = { query = it },
        placeholder = "Поиск спортсмена"
    )

    val athletes = listOf(
        Triple(
            "Никоноров Михаил",
            "Жёлто-чёрный пояс",
            20
        ),
        Triple(
            "Блинов Ярослав",
            "Жёлтый пояс",
            17
        ),
        Triple(
            "Ежов Матвей",
            "Серо-чёрный пояс",
            12
        ),
        Triple(
            "Никонорова Татьяна",
            "Серый пояс",
            20
        ),
        Triple(
            "Наумов Ангел-Александр",
            "Серый пояс",
            16
        )
    )

    val filteredAthletes = athletes.filter {
        it.first.contains(query, ignoreCase = true)
    }

    filteredAthletes.forEach { athlete ->
        AthleteCard(
            name = athlete.first,
            belt = athlete.second,
            medals = athlete.third,
            onClick = {}
        )
    }

    if (filteredAthletes.isEmpty()) {
        Text(
            text = "Спортсмены не найдены",
            color = KTColors.Muted
        )
    }
}

private data class PreviewEvent(
    val name: String,
    val date: String,
    val address: String,
    val category: String
)

@Composable
private fun EventsPreview() {

    var selectedFilter by remember {
        mutableStateOf("Все")
    }

    val filters = listOf(
        "Все",
        "Турниры",
        "Сборы"
    )

    val events = listOf(
        PreviewEvent(
            name = "Siberian Open Cup 2026",
            date = "07–08 ноября 2026",
            address = "Новосибирск, ул. Фабричная, 17/4",
            category = "Турниры"
        ),
        PreviewEvent(
            name = "Фестиваль по грэпплингу",
            date = "25 октября 2026",
            address = "Новосибирск, ул. Мичурина, 10",
            category = "Турниры"
        ),
        PreviewEvent(
            name = "Воины России",
            date = "10–11 октября 2026",
            address = "Бердск, ул. Дачная, 32",
            category = "Турниры"
        )
    )

    Text(
        text = "МЕРОПРИЯТИЯ",
        style = MaterialTheme.typography.titleLarge
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filters.forEach { filter ->
            KTChip(
                text = filter,
                selected = selectedFilter == filter,
                onClick = { selectedFilter = filter },
                modifier = Modifier.weight(1f)
            )
        }
    }

    val filteredEvents = events.filter {
        selectedFilter == "Все" ||
                it.category == selectedFilter
    }

    filteredEvents.forEach { event ->
        EventCard(
            name = event.name,
            date = event.date,
            address = event.address,
            onClick = {}
        )
    }

    if (filteredEvents.isEmpty()) {
        Text(
            text = "Нет мероприятий",
            color = KTColors.Muted
        )
    }
}

@Composable
private fun ProfilePreview() {

    Text(
        text = "ПРОФИЛЬ",
        style = MaterialTheme.typography.titleLarge
    )

    ProfileCard(
        fullName = "Никоноров Михаил",
        role = "Спортсмен",
        belt = "Жёлто-чёрный пояс",
        onClick = {}
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
}