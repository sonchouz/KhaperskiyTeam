
package com.khaperskiyteam.presentation.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.khaperskiyteam.data.model.UserRole
import com.khaperskiyteam.presentation.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    var currentRole by remember {
        mutableStateOf(UserRole.GUEST)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {

        composable(Routes.WELCOME) {
            WelcomeScreen(
                onLogin = {
                    navController.navigate(Routes.LOGIN)
                },
                onRegister = {
                    navController.navigate(Routes.REGISTER)
                },
                onGuest = {
                    currentRole = UserRole.GUEST
                    navController.navigate(Routes.HOME)
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLogin = {
                    currentRole = UserRole.ATHLETE
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.WELCOME) {
                            inclusive = true
                        }
                    }
                },
                onRegister = {
                    navController.navigate(Routes.REGISTER)
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onComplete = {
                    currentRole = UserRole.ATHLETE
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.WELCOME) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                role = currentRole,
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Routes.SCHEDULE) {
            ScheduleScreen()
        }

        composable(Routes.GROUPS) {
            GroupsScreen()
        }

        composable(Routes.MEMBERSHIPS) {
            MembershipsScreen()
        }

        composable(Routes.ATHLETES) {
            AthletesScreen()
        }

        composable(Routes.EVENTS) {
            EventsScreen()
        }

        composable(Routes.PROFILE) {
            ProfileScreen()
        }

        composable(Routes.TRAINER) {
            TrainerScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Routes.TRAINER_SCHEDULE) {
            TrainerScheduleScreen()
        }

        composable(Routes.EDIT_TRAINING) {
            EditTrainingScreen()
        }

        composable(Routes.ATHLETE_BOOKINGS) {
            AthleteBookingsScreen()
        }

        composable(Routes.ADMIN) {
            AdminScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }

        composable(Routes.ADMIN_USERS) {
            AdminUsersScreen()
        }

        composable(Routes.ADMIN_GROUPS) {
            AdminGroupsScreen()
        }
    }
}
