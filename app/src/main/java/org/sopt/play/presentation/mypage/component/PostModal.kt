package org.sopt.play.presentation.mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.component.PlaySoptButton
import org.sopt.play.core.designsystem.component.PlaySoptButtonType
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PostModal(
    onCancelClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 36.dp)
            .fillMaxWidth()
            .background(
                color = PLAYSOPTTheme.colors.white,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Text(
            text = "게시글을 삭제할까요?",
            style = PLAYSOPTTheme.typography.body.m18,
            color = PLAYSOPTTheme.colors.gray6,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ){
            PlaySoptButton(
                text = "취소",
                modifier = Modifier.weight(1f),
                onClick = onCancelClick,
                type = PlaySoptButtonType.Secondary,
            )

            PlaySoptButton(
                text = "삭제",
                modifier = Modifier.weight(1f),
                onClick = onDeleteClick,
                type = PlaySoptButtonType.Primary,
                enabled = true,
            )
        }
    }
}

@Preview
@Composable
private fun PostModalPreview(){
    PlaySoptTheme {
        PostModal(
            onCancelClick = {},
            onDeleteClick = {},
        )
    }
}
