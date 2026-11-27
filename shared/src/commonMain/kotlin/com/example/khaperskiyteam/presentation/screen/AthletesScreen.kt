package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
fun AthletesScreen(
    repository: AthleteRepository
) {

    var athletes by remember {
        mutableStateOf<List<PublicAthleteDto>>(emptyList())
    }

    var query by remember {
        mutableStateOf("")
    }

    var loading by remember {
        mutableStateOf(true)
    }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    var selectedAthlete by remember {
        mutableStateOf<PublicAthleteDto?>(null)
    }

    var reload by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(reload) {

        loading = true
        error = null

        repository.getAthletes()
            .onSuccess {
                athletes = it
            }
            .onFailure {
                error = it.message
                    ?: "Ошибка загрузки"
            }

        loading = false
    }

    val filteredAthletes = remember(
        athletes,
        query
    ) {

        athletes.filter {

            it.fullName.contains(
                query.trim(),
                ignoreCase = true
            ) ||

                    it.beltName.contains(
                        query.trim(),
                        ignoreCase = true
                    )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "СПОРТСМЕНЫ",
            style = MaterialTheme.typography.headlineMedium
        )

        KTTextField(
            value = query,
            onValueChange = {
                query = it
            },
            placeholder = "Поиск спортсмена"
        )

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

            filteredAthletes.isEmpty() -> {

                Text(
                    text = if (query.isBlank())
                        "Пока нет публичных профилей спортсменов"
                    else
                        "Спортсмены не найдены",

                    color = KTColors.Muted
                )
            }

            else -> {

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    items(
                        items = filteredAthletes,
                        key = { it.id }
                    ) { athlete ->

                        AthleteCard(
                            name = athlete.fullName,
                            belt = athlete.beltName,
                            medals = athlete.medalsCount
                                .coerceAtMost(Int.MAX_VALUE.toLong())
                                .toInt(),

                            onClick = {
                                selectedAthlete = athlete
                            }
                        )
                    }
                }
            }
        }
    }

    selectedAthlete?.let { athlete ->

        AlertDialog(
            onDismissRequest = {
                selectedAthlete = null
            },

            title = {
                Text(athlete.fullName)
            },

            text = {

                Column(
                    verticalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    Text(
                        "Пояс: ${athlete.beltName}"
                    )

                    Text(
                        "Достижений: ${athlete.medalsCount}"
                    )
                }
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        selectedAthlete = null
                    }
                ) {
                    Text("Закрыть")
                }
            }
        )
    }
}