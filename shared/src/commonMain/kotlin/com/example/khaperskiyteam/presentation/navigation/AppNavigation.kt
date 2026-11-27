package com.example.khaperskiyteam.presentation.navigation

import androidx.compose.runtime.*
import com.example.khaperskiyteam.data.repository.*
import com.example.khaperskiyteam.presentation.screens.auth.*
import com.example.khaperskiyteam.presentation.screens.main.*

@Composable
fun AppNavigator() {

    val authRepository = remember {
        AuthRepository()
    }

    val membershipRepository = remember {
        MembershipRepository()
    }

    val athleteRepository = remember {
        AthleteRepository()
    }

    val eventRepository = remember {
        EventRepository()
    }

    val profileRepository = remember {
        ProfileRepository()
    }

    var screen by remember {
        mutableStateOf(Screen.Splash)
    }

    var isGuest by remember {
        mutableStateOf(false)
    }

    when (screen) {

        Screen.Splash -> {
            SplashScreen()

            LaunchedEffect(Unit) {

                authRepository.awaitInitialization()

                kotlinx.coroutines.delay(1200)

                screen = if (
                    authRepository.isAuthenticated()
                ) {
                    Screen.Main
                } else {
                    Screen.Welcome
                }
            }
        }

        Screen.Welcome -> {

            WelcomeScreen(
                onLogin = {
                    screen = Screen.Login
                },
                onRegistration = {
                    screen = Screen.Registration
                },
                onGuest = {
                    isGuest = true
                    screen = Screen.Main
                }
            )
        }

        Screen.Login -> {

            LoginScreen(
                repository = authRepository,
                onSuccess = {
                    isGuest = false
                    screen = Screen.Main
                },
                onBack = {
                    screen = Screen.Welcome
                },
                onRegistration = {
                    screen = Screen.Registration
                }
            )
        }

        Screen.Registration -> {

            RegistrationScreen(
                repository = authRepository,
                onSuccess = {
                    screen = Screen.RegistrationSuccess
                },
                onBack = {
                    screen = Screen.Welcome
                }
            )
        }

        Screen.RegistrationSuccess -> {

            RegistrationSuccessScreen(
                onContinue = {

                    isGuest = false

                    screen = if (
                        authRepository.isAuthenticated()
                    ) {
                        Screen.Main
                    } else {
                        Screen.Login
                    }
                }
            )
        }

        Screen.Main -> {

            MainScreen(
                isGuest = isGuest,
                authRepository = authRepository,
                membershipRepository = membershipRepository,
                athleteRepository = athleteRepository,
                eventRepository = eventRepository,
                profileRepository = profileRepository,
                onLogout = {
                    isGuest = false
                    screen = Screen.Welcome
                }
            )
        }
    }
}