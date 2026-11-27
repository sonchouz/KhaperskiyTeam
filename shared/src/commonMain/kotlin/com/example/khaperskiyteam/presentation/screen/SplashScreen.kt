package com.example.khaperskiyteam.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import khaperskiyteam.shared.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(KTColors.Background),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(
                Res.drawable.membership_logo
            ),
            contentDescription = "Khaperskiy Team",
            modifier = Modifier.size(220.dp),
            contentScale = ContentScale.Fit
        )
    }
}