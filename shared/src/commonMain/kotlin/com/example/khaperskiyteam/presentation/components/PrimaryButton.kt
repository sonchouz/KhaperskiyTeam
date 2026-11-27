package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.khaperskiyteam.presentation.theme.*

@Composable
fun KTPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(KTDimens.ButtonHeight),
        shape = RoundedCornerShape(KTDimens.ButtonRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = KTColors.Primary,
            contentColor = KTColors.White,
            disabledContainerColor = KTColors.Border,
            disabledContentColor = KTColors.Muted
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun KTOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(KTDimens.ButtonHeight),
        shape = RoundedCornerShape(KTDimens.ButtonRadius),
        border = BorderStroke(
            width = KTDimens.SpaceXS / 4,
            color = if (enabled)
                KTColors.Primary
            else
                KTColors.Border
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = KTColors.White,
            disabledContentColor = KTColors.Muted
        )
    ) {
        Text(text)
    }
}

@Composable
fun KTTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = KTColors.Primary,
            disabledContentColor = KTColors.Muted
        )
    ) {
        Text(text)
    }
}