package com.example.khaperskiyteam.presentation.components



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.KTCard
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun MembershipCard(
    name: String,
    lessonsCount: Int,
    validity: String,
    price: String,
    modifier: Modifier = Modifier
) {
    KTCard(
        modifier = modifier,
        contentPadding = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(KTColors.SurfaceVariant)
                .padding(20.dp)
        ) {
            Text(
                text = "KHAPERSKIY TEAM",
                color = KTColors.Red,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(Modifier.height(18.dp))

            Text(
                text = name,
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "$lessonsCount тренировок",
                color = Color.White
            )

            Text(
                text = "Срок действия: $validity",
                color = KTColors.TextSecondary
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = price,
                color = KTColors.Red,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
