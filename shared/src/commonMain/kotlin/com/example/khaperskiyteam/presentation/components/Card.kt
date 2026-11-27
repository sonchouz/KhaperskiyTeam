package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.khaperskiyteam.presentation.theme.*

@Composable
fun KTCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = KTColors.Card,
    contentPadding: Dp = KTDimens.CardPadding,
    cornerRadius: Dp = KTDimens.CardRadius,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor =
                if (
                    backgroundColor == KTColors.White ||
                    backgroundColor == KTColors.LightGray
                ) KTColors.Black
                else KTColors.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding),
            content = content
        )
    }
}