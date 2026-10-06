package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PlaySoptButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean = false,
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(100.dp),
                color = if (enabled) PLAYSOPTTheme.colors.black else PLAYSOPTTheme.colors.gray1,
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = text,
            style = PLAYSOPTTheme.typography.caption.sb14,
            color = if (enabled) PLAYSOPTTheme.colors.gray1 else PLAYSOPTTheme.colors.gray3,
        )
    }
}

@Preview
@Composable
private fun PlaySoptButtonPreview(){
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
