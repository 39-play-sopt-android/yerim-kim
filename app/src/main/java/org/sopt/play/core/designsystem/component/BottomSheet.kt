package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(color = PLAYSOPTTheme.colors.white)
            .padding(horizontal = 16.dp)

    ){
        Box(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 20.dp)
                .width(36.dp)
                .height(4.dp)
                .background(
                    color = PLAYSOPTTheme.colors.gray3,
                    shape = CircleShape,
                )
                .align(Alignment.CenterHorizontally)
        )

        content()

        Box(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .width(108.dp)
                .height(4.dp)
                .background(
                    color = PLAYSOPTTheme.colors.black,
                    shape = CircleShape,
                )
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun BottomSheetPreview(){
    PlaySoptTheme {
        BottomSheet(
            content = {
                Box(modifier = Modifier.height(216.dp))
            },
        )
    }
}