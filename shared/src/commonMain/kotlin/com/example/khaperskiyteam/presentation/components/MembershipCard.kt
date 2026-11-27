package com.example.khaperskiyteam.presentation.components

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
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun MembershipCard(
    name: String,
    price: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    background: Painter? = null,
    logo: Painter? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(KTColors.LightGray)
            .clickable(onClick = onClick)
    ) {
        if (background != null) {
            Image(
                painter = background,
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name.uppercase(),
                    color = KTColors.Black,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .background(KTColors.PrimaryDark)
                        .padding(
                            horizontal = 16.dp,
                            vertical = 5.dp
                        )
                ) {
                    Text(
                        text = price,
                        color = KTColors.White,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }

            if (logo != null) {
                Image(
                    painter = logo,
                    contentDescription = "Khaperskiy Team",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}