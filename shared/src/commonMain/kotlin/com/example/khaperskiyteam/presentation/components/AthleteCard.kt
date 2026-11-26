package com.example.khaperskiyteam.presentation.components




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.KTCard
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun AthleteCard(
    fullName: String,
    age: Int,
    belt: String,
    medals: Int,
    modifier: Modifier = Modifier
) {
    KTCard(
        modifier = modifier,
        contentPadding = 12.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(KTColors.SurfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = fullName.firstOrNull()?.uppercase() ?: "?",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = fullName,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    text = "$age лет • $belt пояс",
                    color = KTColors.TextSecondary,
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(Modifier.height(5.dp))

                Text(
                    text = "🏅 $medals медалей",
                    color = KTColors.Red,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
