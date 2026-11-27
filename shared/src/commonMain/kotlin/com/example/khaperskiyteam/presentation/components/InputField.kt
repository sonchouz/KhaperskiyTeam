package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.khaperskiyteam.presentation.theme.*

@Composable
fun KTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    label: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    errorMessage: String = "",
    light: Boolean = false,
    visualTransformation: VisualTransformation =
        VisualTransformation.None,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions.Default,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val textColor =
        if (light) KTColors.Black else KTColors.White

    val containerColor =
        if (light) KTColors.LightGray else KTColors.Border

    Column(modifier = modifier.fillMaxWidth()) {

        if (label.isNotEmpty()) {
            Text(
                text = label,
                color = KTColors.Muted,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(Modifier.height(KTDimens.SpaceXS))
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            enabled = enabled,
            isError = isError,
            singleLine = true,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(KTDimens.InputRadius),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,

                focusedContainerColor =
                    if (light) KTColors.White
                    else KTColors.Background,

                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                errorContainerColor = containerColor,

                focusedBorderColor = KTColors.Primary,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = KTColors.Error,

                cursorColor = KTColors.Primary,

                focusedPlaceholderColor = KTColors.Muted,
                unfocusedPlaceholderColor = KTColors.Muted
            )
        )

        if (isError && errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = KTColors.Error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun KTPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Пароль",
    light: Boolean = false,
    isError: Boolean = false
) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    KTTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = "Введите пароль",
        modifier = modifier,
        label = label,
        light = light,
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation =
            if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
        trailingIcon = {
            TextButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {
                Text(
                    text = if (passwordVisible)
                        "Скрыть"
                    else
                        "Показать",
                    color = KTColors.Muted,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    )
}