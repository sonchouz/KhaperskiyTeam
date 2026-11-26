package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.khaperskiyteam.presentation.theme.KTColors
import com.example.khaperskiyteam.presentation.theme.KTDimens

@Composable
fun KTPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(KTDimens.ButtonHeight),
        enabled = enabled,
        shape = RoundedCornerShape(KTDimens.ButtonRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = KTColors.Red,
            contentColor = KTColors.White,
            disabledContainerColor = KTColors.SurfaceVariant,
            disabledContentColor = KTColors.TextDisabled
        )
    ) {
        Text(
            text = text,
            style = androidx.compose.material3.MaterialTheme
                .typography.labelLarge
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
        modifier = modifier
            .fillMaxWidth()
            .height(KTDimens.ButtonHeight),
        enabled = enabled,
        shape = RoundedCornerShape(KTDimens.ButtonRadius),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = KTColors.White
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun KTTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text,
            color = KTColors.Red
        )
    }
}