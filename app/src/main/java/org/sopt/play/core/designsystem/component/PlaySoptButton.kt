package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable

@Composable
fun PlaySoptButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = CircleShape,
                color = if (enabled) PLAYSOPTTheme.colors.black else PLAYSOPTTheme.colors.gray1,
            )
            .noRippleClickable(
                enabled = enabled,
                onClick = onClick,
            )
            .padding(16.dp),
        color = if (enabled) PLAYSOPTTheme.colors.gray1 else PLAYSOPTTheme.colors.gray3,
        textAlign = TextAlign.Center,
        style = PLAYSOPTTheme.typography.caption.sb14,
    )
}

@Preview
@Composable
private fun PlaySoptButtonPreview() {
    PlaySoptTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            PlaySoptButton(
                text = "로그인",
                onClick = {},
                modifier = Modifier,
            )

            PlaySoptButton(
                text = "회원가입",
                onClick = {},
                modifier = Modifier,
                enabled = true,
            )
        }
    }
}
