package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationSuccessScreen(
    onContinue: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "✓",
            color = KTColors.Success,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "Регистрация выполнена!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Если требуется подтверждение email, проверьте почту.",
            color = KTColors.Muted,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(32.dp))

        KTPrimaryButton(
            text = "Продолжить",
            onClick = onContinue
        )
    }
}