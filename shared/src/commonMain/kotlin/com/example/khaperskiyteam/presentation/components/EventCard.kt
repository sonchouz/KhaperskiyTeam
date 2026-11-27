package com.example.khaperskiyteam.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun EventCard(
    name: String,
    date: String,
    address: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    photo: Painter? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(KTColors.Surface)
            .clickable(onClick = onClick)
    ) {
        if (photo != null) {
            Image(
                painter = photo,
                contentDescription = name,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.65f),
                            Color.Black.copy(alpha = 0.40f),
                            Color.Black.copy(alpha = 0.80f)
                        )
                    )
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = name,
                    color = KTColors.White,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = date,
                    color = KTColors.White,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = address,
                    color = KTColors.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = "›",
                color = KTColors.Primary,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}