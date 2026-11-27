package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun ProfileMenuItem(
    title: String,
    subtitle: String = "",
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    isDestructive: Boolean = false
) {
    val contentColor =
        if (isDestructive)
            KTColors.Primary
        else
            KTColors.White

    KTCard(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(Modifier.width(16.dp))
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    color = contentColor,
                    style = MaterialTheme.typography.titleSmall
                )

                if (subtitle.isNotEmpty()) {
                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = subtitle,
                        color = KTColors.Muted,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Text(
                text = "›",
                color = contentColor,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}