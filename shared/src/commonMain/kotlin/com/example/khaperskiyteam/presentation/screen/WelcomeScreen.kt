package com.example.khaperskiyteam.presentation.screen

import androidx.compose.runtime.Composable

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit,
    onRegister: () -> Unit,
    onGuest: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "KHAPERSKIY",
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            color = White
        )

        Text(
            text = "TEAM",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = TeamRed
        )

        Spacer(Modifier.height(50.dp))

        Text(
            text = "ТВОЯ КОМАНДА.\nТВОЙ ПУТЬ.",
            fontSize = 28.sp,
            fontWeight = FontWeight.Black,
            color = White
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Тренируйся, развивайся и достигай новых побед вместе с Khaperskiy Team.",
            color = Gray,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(32.dp))

        TeamButton("Войти", onClick = onLogin)

        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = onRegister,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Зарегистрироваться", color = White)
        }

        TextButton(onClick = onGuest) {
            Text("Продолжить как гость", color = Gray)
        }
    }
}