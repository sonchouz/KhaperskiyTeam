package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    repository: AuthRepository,
    onSuccess: () -> Unit,
    onBack: () -> Unit,
    onRegistration: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        KTTextButton(
            text = "‹ Назад",
            onClick = onBack,
            enabled = !loading
        )

        Text(
            text = "ВХОД",
            style = MaterialTheme.typography.headlineLarge
        )

        KTTextField(
            value = email,
            onValueChange = {
                email = it
                error = null
            },
            placeholder = "Введите email",
            label = "Email",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        KTPasswordField(
            value = password,
            onValueChange = {
                password = it
                error = null
            }
        )

        error?.let {
            Text(
                text = it,
                color = KTColors.Error
            )
        }

        KTPrimaryButton(
            text = if (loading)
                "Выполняется вход..."
            else "Войти",

            enabled = !loading,

            onClick = {

                if (email.isBlank() ||
                    password.isBlank()
                ) {

                    error = "Заполните все поля"

                } else {

                    scope.launch {

                        loading = true
                        error = null

                        val result = repository.signIn(
                            email,
                            password
                        )

                        loading = false

                        result.onSuccess {
                            onSuccess()
                        }.onFailure {
                            error = it.message
                                ?: "Ошибка авторизации"
                        }
                    }
                }
            }
        )

        KTTextButton(
            text = "Нет аккаунта? Зарегистрироваться",
            onClick = onRegistration,
            enabled = !loading
        )
    }
}