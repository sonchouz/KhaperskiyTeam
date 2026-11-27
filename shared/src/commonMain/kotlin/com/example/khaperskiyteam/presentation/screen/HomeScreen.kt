package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun HomeScreen(
    athleteRepository: AthleteRepository,
    membershipRepository: MembershipRepository,
    eventRepository: EventRepository,
    onMemberships: () -> Unit,
    onAthletes: () -> Unit,
    onEvents: () -> Unit
) {

    var athletesCount by remember {
        mutableStateOf<Int?>(null)
    }

    var membershipsCount by remember {
        mutableStateOf<Int?>(null)
    }

    var eventsCount by remember {
        mutableStateOf<Int?>(null)
    }

    LaunchedEffect(Unit) {

        athleteRepository.getAthletes()
            .onSuccess {
                athletesCount = it.size
            }

        membershipRepository.getMemberships()
            .onSuccess {
                membershipsCount = it.size
            }

        eventRepository.getEvents()
            .onSuccess {
                eventsCount = it.size
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Text(
            text = "KHAPERSKIY TEAM",
            color = KTColors.Primary,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "О НАШЕЙ КОМАНДЕ",
            style = MaterialTheme.typography.headlineMedium
        )

        KTCard {

            Text(
                text = "Khaperskiy Team",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Спортивная команда по бразильскому джиу-джитсу."
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            StatisticCard(
                value = athletesCount?.toString() ?: "—",
                label = "Публичных спортсменов",
                modifier = Modifier.weight(1f)
            )

            StatisticCard(
                value = membershipsCount?.toString() ?: "—",
                label = "Абонементов",
                modifier = Modifier.weight(1f)
            )

            StatisticCard(
                value = eventsCount?.toString() ?: "—",
                label = "Событий",
                modifier = Modifier.weight(1f)
            )
        }

        KTPrimaryButton(
            text = "Наши спортсмены",
            onClick = onAthletes
        )

        KTOutlinedButton(
            text = "Абонементы",
            onClick = onMemberships
        )

        KTOutlinedButton(
            text = "События команды",
            onClick = onEvents
        )
    }
}

@Composable
private fun StatisticCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {

    KTCard(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = value,
                color = KTColors.Primary,
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}