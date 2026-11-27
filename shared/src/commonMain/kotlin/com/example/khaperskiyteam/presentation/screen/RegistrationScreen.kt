package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(
    repository: AuthRepository,
    onSuccess: () -> Unit,
    onBack: () -> Unit
) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var consent by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }

    var error by remember {
        mutableStateOf<String?>(null)
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),

        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        KTTextButton(
            text = "‹ Назад",
            onClick = onBack,
            enabled = !loading
        )

        Text(
            text = "РЕГИСТРАЦИЯ",
            style = MaterialTheme.typography.headlineLarge
        )

        KTTextField(
            value = lastName,
            onValueChange = { lastName = it },
            placeholder = "Введите фамилию",
            label = "Фамилия"
        )

        KTTextField(
            value = firstName,
            onValueChange = { firstName = it },
            placeholder = "Введите имя",
            label = "Имя"
        )

        KTTextField(
            value = middleName,
            onValueChange = { middleName = it },
            placeholder = "При наличии",
            label = "Отчество"
        )

        KTTextField(
            value = birthDate,
            onValueChange = {
                if (it.length <= 10) {
                    birthDate = it
                }
            },
            placeholder = "ДД.ММ.ГГГГ",
            label = "Дата рождения"
        )

        KTTextField(
            value = phone,
            onValueChange = { phone = it },
            placeholder = "+7 999 999 99 99",
            label = "Телефон",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )

        KTTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "example@mail.ru",
            label = "Email",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        KTPasswordField(
            value = password,
            onValueChange = { password = it },
            label = "Пароль"
        )

        KTPasswordField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = "Повторите пароль"
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = consent,
                onCheckedChange = {
                    consent = it
                }
            )

            Text(
                text = "Согласен на обработку персональных данных",
                style = MaterialTheme.typography.bodySmall
            )
        }

        error?.let {

            Text(
                text = it,
                color = KTColors.Error
            )
        }

        KTPrimaryButton(
            text = if (loading)
                "Регистрация..."
            else "Зарегистрироваться",

            enabled = !loading,

            onClick = {

                val isoDate = convertBirthDate(
                    birthDate
                )

                error = when {

                    firstName.isBlank() ||
                            lastName.isBlank() ||
                            phone.isBlank() ||
                            email.isBlank() ||
                            password.isBlank() ->
                        "Заполните обязательные поля"

                    isoDate == null ->
                        "Введите корректную дату рождения"

                    !email.contains("@") ->
                        "Введите корректный email"

                    phone.count { it.isDigit() } < 10 ->
                        "Введите корректный телефон"

                    password.length < 8 ->
                        "Минимальная длина пароля — 8 символов"

                    password != confirmPassword ->
                        "Пароли не совпадают"

                    !consent ->
                        "Необходимо дать согласие"

                    else -> null
                }

                if (error == null && isoDate != null) {

                    scope.launch {

                        loading = true

                        val result = repository.signUp(
                            email = email,
                            password = password,
                            firstName = firstName,
                            lastName = lastName,
                            middleName = middleName,
                            birthDate = isoDate,
                            phone = phone
                        )

                        loading = false

                        result.onSuccess {
                            onSuccess()
                        }.onFailure {
                            error = it.message
                                ?: "Ошибка регистрации"
                        }
                    }
                }
            }
        )
    }
}

private fun convertBirthDate(
    value: String
): String? {

    val parts = value.split(".")

    if (parts.size != 3) return null

    if (
        parts[0].length != 2 ||
        parts[1].length != 2 ||
        parts[2].length != 4
    ) return null

    val day = parts[0].toIntOrNull()
        ?: return null

    val month = parts[1].toIntOrNull()
        ?: return null

    val year = parts[2].toIntOrNull()
        ?: return null

    if (year !in 1900..2026) return null
    if (month !in 1..12) return null

    val leapYear = year % 400 == 0 ||
            (year % 4 == 0 && year % 100 != 0)

    val maxDay = when (month) {

        2 -> if (leapYear) 29 else 28

        4, 6, 9, 11 -> 30

        else -> 31
    }

    if (day !in 1..maxDay) return null

    return "${parts[2]}-${parts[1]}-${parts[0]}"
}