package org.sopt.play.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object PLAYSOPTTheme {
    val colors: PLAYSOPTColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPLAYSOPTColors.current

    val typography: PLAYSOPTTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalPLAYSOPTTypography.current
}

@Composable
fun ProvidePLAYSOPTColorsAndTypography(
    colors: PLAYSOPTColors,
    typography: PLAYSOPTTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPLAYSOPTColors provides colors,
        LocalPLAYSOPTTypography provides typography,
        content = content
    )
}

@Composable
fun PlaySoptTheme(
    content: @Composable () -> Unit
) {
    ProvidePLAYSOPTColorsAndTypography(
        colors = defaultPLAYSOPTColors,
        typography = defaultPLAYSOPTTypography,
    ) {
        MaterialTheme(
            content = content
        )
    }
}
