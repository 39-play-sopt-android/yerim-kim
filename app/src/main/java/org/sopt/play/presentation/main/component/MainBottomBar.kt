package org.sopt.play.presentation.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable
import org.sopt.play.presentation.main.model.BottomBarItemModel

@Composable
fun MainBottomBar(
    selectedTab: BottomBarItemModel,
    onTabClick: (BottomBarItemModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row {
        BottomBarItemModel.entries.forEach { item ->
            BottomBarItem(
                bottomTab = item,
                onTabClick = onTabClick,
                modifier = modifier.weight(1f),
                isSelected = selectedTab == item,
            )
        }
    }
}

@Composable
private fun BottomBarItem(
    bottomTab: BottomBarItemModel,
    onTabClick: (BottomBarItemModel) -> Unit,
    modifier: Modifier,
    isSelected: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable({ onTabClick(bottomTab) })
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(if (isSelected) bottomTab.filledIcon else bottomTab.defaultIcon),
            contentDescription = bottomTab.label,
            modifier = Modifier.size(24.dp),
            tint = PLAYSOPTTheme.colors.black,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = bottomTab.label,
            style = PLAYSOPTTheme.typography.caption.sb14,
            color = PLAYSOPTTheme.colors.black,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainBottomBarPreview() {
    PlaySoptTheme {
        var selectedTab by rememberSaveable {
            mutableStateOf(BottomBarItemModel.HOME)
        }

        MainBottomBar(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it },
        )
    }
}
