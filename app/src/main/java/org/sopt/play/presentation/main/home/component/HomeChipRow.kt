package org.sopt.play.presentation.main.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.presentation.main.home.model.HomeCategoryModel

@Composable
fun HomeChipRow(
    selectedCategory: HomeCategoryModel,
    onChipClick: (HomeCategoryModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(HomeCategoryModel.entries) { category ->
            PlaySoptChip(
                category = category,
                isSelected = category == selectedCategory,
                onChipClick = { onChipClick(category) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeChipRowPreview() {
    PlaySoptTheme {
        var selectedCategory by remember {
            mutableStateOf(HomeCategoryModel.ALL)
        }
        HomeChipRow(
            selectedCategory = selectedCategory,
            onChipClick = { selectedCategory = it }
        )
    }
}
