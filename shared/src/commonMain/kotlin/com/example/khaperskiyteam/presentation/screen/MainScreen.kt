package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    isGuest: Boolean,
    authRepository: AuthRepository,
    membershipRepository: MembershipRepository,
    athleteRepository: AthleteRepository,
    eventRepository: EventRepository,
    profileRepository: ProfileRepository,
    onLogout: () -> Unit
) {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    Scaffold(
        containerColor = KTColors.Background,

        bottomBar = {

            Box(
                modifier = Modifier.navigationBarsPadding()
            ) {

                KTBottomNavigation(
                    selected = selectedTab,
                    onSelect = {
                        selectedTab = it
                    }
                )
            }
        }

    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            when (selectedTab) {

                0 -> HomeScreen(
                    athleteRepository = athleteRepository,
                    membershipRepository = membershipRepository,
                    eventRepository = eventRepository,
                    onMemberships = {
                        selectedTab = 1
                    },
                    onAthletes = {
                        selectedTab = 2
                    },
                    onEvents = {
                        selectedTab = 3
                    }
                )

                1 -> MembershipsScreen(
                    repository = membershipRepository
                )

                2 -> AthletesScreen(
                    repository = athleteRepository
                )

                3 -> EventsScreen(
                    repository = eventRepository
                )

                4 -> ProfileScreen(
                    isGuest = isGuest,
                    authRepository = authRepository,
                    profileRepository = profileRepository,
                    onLogout = onLogout
                )
            }
        }
    }
}