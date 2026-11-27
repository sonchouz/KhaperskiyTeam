package com.example.khaperskiyteam.presentation.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.components.KTCard
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun GroupCard(
    name: String,
    schedule: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    photo: Painter? = null
) {
    KTCard(
        modifier = modifier.clickable(onClick = onClick),
        backgroundColor = KTColors.White,
        contentPadding = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
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
                    .padding(12.dp)
            ) {
                Text(
                    text = name,
                    color = KTColors.Black,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = schedule,
                    color = KTColors.Muted,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}