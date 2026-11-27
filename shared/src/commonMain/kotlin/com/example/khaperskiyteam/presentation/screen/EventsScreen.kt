package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventsScreen(
    repository: EventRepository
) {

    var events by remember {
        mutableStateOf<List<EventDto>>(emptyList())
    }

    var categories by remember {
        mutableStateOf<List<EventCategoryDto>>(emptyList())
    }

    var selectedCategory by remember {
        mutableStateOf<Int?>(null)
    }

    var selectedEvent by remember {
        mutableStateOf<EventDto?>(null)
    }

    var loading by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    var reload by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(reload) {

        loading = true
        error = null

        repository.getCategories()
            .onSuccess {
                categories = it
            }
            .onFailure {
                error = it.message
                    ?: "Ошибка загрузки категорий"
            }

        repository.getEvents()
            .onSuccess {
                events = it
            }
            .onFailure {
                error = it.message
                    ?: "Ошибка загрузки событий"
            }

        loading = false
    }

    val filteredEvents = remember(
        events,
        selectedCategory
    ) {

        events.filter {

            selectedCategory == null ||
                    it.categoryId == selectedCategory

        }.sortedBy {
            it.startsAt
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "СОБЫТИЯ",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyRow(
            horizontalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            item {

                KTChip(
                    text = "Все",
                    selected = selectedCategory == null,
                    onClick = {
                        selectedCategory = null
                    }
                )
            }

            items(categories) { category ->

                KTChip(
                    text = category.name,
                    selected = selectedCategory == category.id,
                    onClick = {
                        selectedCategory = category.id
                    }
                )
            }
        }

        when {

            loading -> {

                Box(
                    modifier = Modifier.weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    CircularProgressIndicator(
                        color = KTColors.Primary
                    )
                }
            }

            error != null -> {

                Text(
                    text = error.orEmpty(),
                    color = KTColors.Error
                )

                KTPrimaryButton(
                    text = "Повторить",
                    onClick = { reload++ }
                )
            }

            filteredEvents.isEmpty() -> {

                Text(
                    text = "События отсутствуют",
                    color = KTColors.Muted
                )
            }

            else -> {

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement =
                        Arrangement.spacedBy(16.dp)
                ) {

                    items(
                        items = filteredEvents,
                        key = { it.id }
                    ) { event ->

                        EventCard(
                            name = event.title,
                            date = formatEventDate(
                                event.startsAt
                            ),
                            address = event.location,
                            onClick = {
                                selectedEvent = event
                            }
                        )
                    }
                }
            }
        }
    }

    selectedEvent?.let { event ->

        AlertDialog(
            onDismissRequest = {
                selectedEvent = null
            },

            title = {
                Text(event.title)
            },

            text = {

                Column(
                    verticalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        "Дата: ${formatEventDate(event.startsAt)}"
                    )

                    Text(
                        "Место: ${event.location}"
                    )

                    Text(
                        event.description
                            ?: "Описание отсутствует"
                    )
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        selectedEvent = null
                    }
                ) {
                    Text("Закрыть")
                }
            }
        )
    }
}

private fun formatEventDate(
    value: String
): String {

    val date = value.take(10)
    val parts = date.split("-")

    return if (parts.size == 3) {

        "${parts[2]}.${parts[1]}.${parts[0]}"

    } else {

        value
    }
}