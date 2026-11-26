package com.example.khaperskiyteam.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.khaperskiyteam.presentation.theme.KTColors
import com.example.khaperskiyteam.presentation.theme.KTDimens

@Composable
fun KTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = true,
    isError: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(KTDimens.TextFieldHeight),
        label = {
            Text(label)
        },
        placeholder = {
            Text(placeholder)
        },
        enabled = enabled,
        singleLine = singleLine,
        isError = isError,
        shape = RoundedCornerShape(KTDimens.TextFieldRadius),
        textStyle = MaterialTheme.typography.bodyMedium,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = KTColors.Red,
            unfocusedBorderColor = KTColors.Border,
            focusedLabelColor = KTColors.Red,
            unfocusedLabelColor = KTColors.TextSecondary,
            focusedTextColor = KTColors.White,
            unfocusedTextColor = KTColors.White,
            cursorColor = KTColors.Red,
            focusedContainerColor = KTColors.Surface,
            unfocusedContainerColor = KTColors.Surface,
            errorBorderColor = KTColors.Error
        )
    )
}