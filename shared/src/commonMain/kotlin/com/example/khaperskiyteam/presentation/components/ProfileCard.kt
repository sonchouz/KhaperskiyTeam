package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun ProfileCard(
    fullName: String,
    role: String,
    belt: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    photo: Painter? = null
) {
    KTCard(
        modifier = modifier.clickable(onClick = onClick),
        backgroundColor = KTColors.Border
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 110.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(KTColors.Muted),
                contentAlignment = Alignment.Center
            ) {
                if (photo != null) {
                    Image(
                        painter = photo,
                        contentDescription = fullName,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Text(
                        text = fullName.take(1).uppercase(),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = fullName,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = role,
                    color = KTColors.Muted
                )

                Text(
                    text = belt,
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