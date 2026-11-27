package org.sopt.play.core.common.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Modifier.noRippleClickable(
    onClick: () -> Unit,
    enabled: Boolean = true,
): Modifier =
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick,
        enabled = enabled,
    )

@Composable
fun Modifier.noRippleCombineClickable(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    enabled: Boolean = true,
): Modifier =
    this.combinedClickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick,
        onLongClick = onLongClick,
        enabled = enabled,
    )
