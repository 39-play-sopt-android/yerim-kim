package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun PlaySoptChip(
    chipText: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Text(
        text = chipText,
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(
                color = if (isSelected) PLAYSOPTTheme.colors.white else PLAYSOPTTheme.colors.gray5,
            )
            .border(
                width = 2.dp,
                color = if (isSelected) PLAYSOPTTheme.colors.gray2 else PLAYSOPTTheme.colors.gray5,
                shape = RoundedCornerShape(6.dp),
            )
            .padding(vertical = 8.dp, horizontal = 12.dp),
        style = PLAYSOPTTheme.typography.caption.m14,
        color = if (isSelected) PLAYSOPTTheme.colors.gray5 else PLAYSOPTTheme.colors.white,
    )
}

@Preview(showBackground = true)
@Composable
private fun PlaySoptChipPreview(){
    PlaySoptTheme {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ){
            PlaySoptChip(
                chipText = "전체",
            )

            PlaySoptChip(
                chipText = "이너웨어/잠옷",
                isSelected = true,
            )
        }
    }
}
