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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    isGuest: Boolean,
    authRepository: AuthRepository,
    profileRepository: ProfileRepository,
    onLogout: () -> Unit
) {

    var profile by remember {
        mutableStateOf<UserDto?>(null)
    }

    var roleName by remember {
        mutableStateOf("Пользователь")
    }

    var beltName by remember {
        mutableStateOf("Пояс не указан")
    }

    var loading by remember {
        mutableStateOf(!isGuest)
    }

    var updating by remember {
        mutableStateOf(false)
    }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    var showLogoutDialog by remember {
        mutableStateOf(false)
    }

    var showPersonalData by remember {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(isGuest) {

        if (!isGuest) {

            loading = true

            val result = profileRepository.getProfile()

            result.onSuccess { user ->

                profile = user

                profileRepository.getRole(user.roleId)
                    .onSuccess {
                        roleName = it.name
                    }

                user.beltId?.let { beltId ->

                    profileRepository.getBelt(beltId)
                        .onSuccess {
                            beltName = it.name
                        }
                }

            }.onFailure {

                error = it.message
                    ?: "Ошибка загрузки профиля"
            }

            loading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "ПРОФИЛЬ",
            style = MaterialTheme.typography.headlineMedium
        )

        if (isGuest) {

            KTCard {

                Text(
                    text = "Гостевой режим",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "Войдите в аккаунт для доступа к личному кабинету."
                )
            }

            KTPrimaryButton(
                text = "Войти или зарегистрироваться",
                onClick = onLogout
            )

        } else {

            if (loading) {

                CircularProgressIndicator(
                    color = KTColors.Primary
                )
            }

            profile?.let { user ->

                ProfileCard(
                    fullName = user.fullName,
                    role = roleName,
                    belt = beltName,
                    onClick = {
                        showPersonalData = true
                    }
                )

                ProfileMenuItem(
                    title = "Личные данные",
                    subtitle = "Просмотр информации",
                    onClick = {
                        showPersonalData = true
                    }
                )

                if (user.roleId == 1) {

                    KTCard {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {

                                Text(
                                    text = "Публичный профиль",
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = "Отображать меня в списке спортсменов",
                                    color = KTColors.Muted,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            Switch(
                                checked = user.publicProfile,
                                enabled = !updating,

                                onCheckedChange = { checked ->

                                    scope.launch {

                                        updating = true
                                        error = null

                                        profileRepository
                                            .setPublicProfile(checked)

                                            .onSuccess {

                                                profile = user.copy(
                                                    publicProfile = checked
                                                )
                                            }

                                            .onFailure {

                                                error = it.message
                                                    ?: "Ошибка сохранения"
                                            }

                                        updating = false
                                    }
                                }
                            )
                        }
                    }
                }
            }

            error?.let {

                Text(
                    text = it,
                    color = KTColors.Error
                )
            }

            ProfileMenuItem(
                title = "Выйти из аккаунта",
                isDestructive = true,
                onClick = {
                    showLogoutDialog = true
                }
            )
        }
    }

    if (showPersonalData) {

        profile?.let { user ->

            AlertDialog(
                onDismissRequest = {
                    showPersonalData = false
                },

                title = {
                    Text("Личные данные")
                },

                text = {

                    Column(
                        verticalArrangement =
                            Arrangement.spacedBy(12.dp)
                    ) {

                        Text("ФИО: ${user.fullName}")

                        Text(
                            "Дата рождения: " +
                                    (user.birthDate ?: "Не указана")
                        )

                        Text(
                            "Телефон: " +
                                    (user.phone ?: "Не указан")
                        )

                        Text(
                            "Email: " +
                                    authRepository
                                        .getCurrentEmail()
                                        .orEmpty()
                        )

                        Text("Роль: $roleName")
                        Text("Пояс: $beltName")
                    }
                },

                confirmButton = {

                    TextButton(
                        onClick = {
                            showPersonalData = false
                        }
                    ) {
                        Text("Закрыть")
                    }
                }
            )
        }
    }

    if (showLogoutDialog) {

        AlertDialog(
            onDismissRequest = {
                showLogoutDialog = false
            },

            title = {
                Text("Выход из аккаунта")
            },

            text = {
                Text("Вы действительно хотите выйти?")
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        showLogoutDialog = false

                        scope.launch {

                            authRepository.signOut()
                                .onSuccess {
                                    onLogout()
                                }
                                .onFailure {
                                    error = "Не удалось выйти"
                                }
                        }
                    }
                ) {

                    Text(
                        text = "Выйти",
                        color = KTColors.Primary
                    )
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    }
                ) {
                    Text("Отмена")
                }
            }
        )
    }
}