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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.KTCard
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun AthleteCard(
    name: String,
    belt: String,
    medals: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    photo: Painter? = null
) {
    KTCard(
        modifier = modifier.clickable(onClick = onClick),
        contentPadding = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(92.dp)
                    .height(112.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(KTColors.LightGray)
            ) {
                if (photo != null) {
                    Image(
                        painter = photo,
                        contentDescription = name,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = belt,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "🏅 $medals медалей",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                text = "›",
                color = KTColors.Primary,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}