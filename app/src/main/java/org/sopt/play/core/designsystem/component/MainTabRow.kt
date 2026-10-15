package org.sopt.play.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.data.model.MainTabModel

@Composable
fun MainTabRow(
    selectedTab: MainTabModel,
    onTabClick: (MainTabModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
    ){
        items(MainTabModel.entries) { tab ->
            MainTabMenu(
                tabText = tab.label,
                onTabClick = { onTabClick(tab) },
                isSelected = selectedTab == tab,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTabRowPreview(){
    PlaySoptTheme {
        var selectedChip by remember {
            mutableStateOf(MainTabModel.HOME)
        }

        MainTabRow(
            selectedTab = selectedChip,
            onTabClick = { selectedChip = it },
        )
    }
}
