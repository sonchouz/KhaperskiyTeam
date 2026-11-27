package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import khaperskiyteam.shared.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
    onRegistration: () -> Unit,
    onGuest: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KTColors.Background)
            .safeDrawingPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.weight(1f))

        Image(
            painter = painterResource(
                Res.drawable.membership_logo
            ),
            contentDescription = null,
            modifier = Modifier.size(220.dp)
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = "KHAPERSKIY TEAM",
            style = MaterialTheme.typography.headlineLarge,
            color = KTColors.White,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.weight(1f))

        KTPrimaryButton(
            text = "Войти",
            onClick = onLogin
        )

        Spacer(Modifier.height(12.dp))

        KTOutlinedButton(
            text = "Зарегистрироваться",
            onClick = onRegistration
        )

        Spacer(Modifier.height(12.dp))

        KTTextButton(
            text = "Войти как гость",
            onClick = onGuest
        )

        Spacer(Modifier.height(24.dp))
    }
}