package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.KTColors

@Composable
fun KTBottomNavigation(
    selected: Int,
    onSelect: (Int) -> Unit
) {
    val labels = listOf(
        "Главная",
        "Абонементы",
        "Спортсмены",
        "События",
        "Профиль"
    )

    NavigationBar(
        containerColor = KTColors.Background,
        tonalElevation = 0.dp
    ) {
        labels.forEachIndexed { index, label ->

            val active = selected == index

            NavigationBarItem(
                selected = active,
                onClick = { onSelect(index) },
                icon = {
                    KTNavigationIcon(
                        index = index,
                        color = if (active)
                            KTColors.Primary
                        else
                            KTColors.Muted
                    )
                },
                label = {
                    Text(
                        text = label,
                        maxLines = 1,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = KTColors.Background,
                    selectedIconColor = KTColors.Primary,
                    selectedTextColor = KTColors.Primary,
                    unselectedIconColor = KTColors.Muted,
                    unselectedTextColor = KTColors.Muted
                )
            )
        }
    }
}

@Composable
private fun KTNavigationIcon(
    index: Int,
    color: Color
) {
    Canvas(
        modifier = Modifier.size(24.dp)
    ) {
        val w = size.width
        val h = size.height
        val stroke = 1.8.dp.toPx()

        when (index) {
            0 -> {
                // Главная
                val path = Path().apply {
                    moveTo(w * 0.08f, h * 0.45f)
                    lineTo(w * 0.5f, h * 0.08f)
                    lineTo(w * 0.92f, h * 0.45f)
                    moveTo(w * 0.2f, h * 0.38f)
                    lineTo(w * 0.2f, h * 0.9f)
                    lineTo(w * 0.8f, h * 0.9f)
                    lineTo(w * 0.8f, h * 0.38f)
                }

                drawPath(path, color, style = Stroke(stroke))

                drawRect(
                    color = color,
                    topLeft = Offset(w * 0.42f, h * 0.6f),
                    size = Size(w * 0.16f, h * 0.3f),
                    style = Stroke(stroke)
                )
            }

            1 -> {
                // Абонементы
                drawRect(
                    color = color,
                    topLeft = Offset(w * 0.08f, h * 0.2f),
                    size = Size(w * 0.84f, h * 0.6f),
                    style = Stroke(stroke)
                )

                drawLine(
                    color,
                    Offset(w * 0.08f, h * 0.4f),
                    Offset(w * 0.92f, h * 0.4f),
                    stroke
                )

                drawLine(
                    color,
                    Offset(w * 0.2f, h * 0.62f),
                    Offset(w * 0.4f, h * 0.62f),
                    stroke
                )
            }

            2 -> {
                // Спортивная форма
                val path = Path().apply {
                    moveTo(w * 0.3f, h * 0.12f)
                    lineTo(w * 0.08f, h * 0.3f)
                    lineTo(w * 0.2f, h * 0.58f)
                    lineTo(w * 0.3f, h * 0.48f)
                    lineTo(w * 0.3f, h * 0.9f)
                    lineTo(w * 0.7f, h * 0.9f)
                    lineTo(w * 0.7f, h * 0.48f)
                    lineTo(w * 0.8f, h * 0.58f)
                    lineTo(w * 0.92f, h * 0.3f)
                    lineTo(w * 0.7f, h * 0.12f)
                    close()
                }

                drawPath(path, color, style = Stroke(stroke))

                drawLine(
                    color,
                    Offset(w * 0.3f, h * 0.12f),
                    Offset(w * 0.65f, h * 0.68f),
                    stroke
                )

                drawLine(
                    color,
                    Offset(w * 0.7f, h * 0.12f),
                    Offset(w * 0.35f, h * 0.68f),
                    stroke
                )
            }

            3 -> {
                // Календарь
                drawRect(
                    color = color,
                    topLeft = Offset(w * 0.12f, h * 0.2f),
                    size = Size(w * 0.76f, h * 0.7f),
                    style = Stroke(stroke)
                )

                drawLine(
                    color,
                    Offset(w * 0.12f, h * 0.4f),
                    Offset(w * 0.88f, h * 0.4f),
                    stroke
                )

                listOf(0.3f, 0.7f).forEach { x ->
                    drawLine(
                        color,
                        Offset(w * x, h * 0.08f),
                        Offset(w * x, h * 0.3f),
                        stroke
                    )
                }

                for (row in 0..1) {
                    for (column in 0..2) {
                        drawCircle(
                            color = color,
                            radius = stroke * 0.55f,
                            center = Offset(
                                w * (0.3f + column * 0.2f),
                                h * (0.55f + row * 0.18f)
                            )
                        )
                    }
                }
            }

            4 -> {
                // Профиль
                drawCircle(
                    color = color,
                    radius = w * 0.18f,
                    center = Offset(w * 0.5f, h * 0.25f),
                    style = Stroke(stroke)
                )

                drawArc(
                    color = color,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    topLeft = Offset(w * 0.15f, h * 0.52f),
                    size = Size(w * 0.7f, h * 0.7f),
                    style = Stroke(stroke)
                )
            }
        }
    }
}