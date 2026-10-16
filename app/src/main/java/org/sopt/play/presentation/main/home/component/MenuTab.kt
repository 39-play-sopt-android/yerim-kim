package org.sopt.play.presentation.main.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable

@Composable
fun MainTabMenu(
    tabText: String,
    onTabClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
){
    Column(
        modifier = modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .noRippleClickable(onTabClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(
                    color = if (isSelected) PLAYSOPTTheme.colors.black else Color.Transparent,
                    shape = CircleShape,
                ),
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = tabText,
            style = PLAYSOPTTheme.typography.body.m18,
            color = if (isSelected) PLAYSOPTTheme.colors.black else PLAYSOPTTheme.colors.gray3,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTabMenuPreview(){
    PlaySoptTheme {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ){
            MainTabMenu(
                tabText = "홈",
                onTabClick = {},
                isSelected = true,
            )

            MainTabMenu(
                tabText = "2배 적립",
                onTabClick = {},
            )
        }
    }
}
