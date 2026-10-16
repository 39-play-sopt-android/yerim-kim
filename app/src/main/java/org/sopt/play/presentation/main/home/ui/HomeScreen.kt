package org.sopt.play.presentation.main.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.data.model.ProductModel
import org.sopt.play.data.model.productMockData
import org.sopt.play.presentation.main.home.component.HomeTabRow
import org.sopt.play.presentation.main.home.component.HomeBanner
import org.sopt.play.presentation.main.home.component.HomeChipRow
import org.sopt.play.presentation.main.component.MainTopBar
import org.sopt.play.presentation.main.home.component.ProductCard
import org.sopt.play.presentation.main.home.model.HomeCategoryModel
import org.sopt.play.presentation.main.home.model.HomeMenuModel

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
) {
    var selectedTab by rememberSaveable {
        mutableStateOf(HomeMenuModel.HOME)
    }
    var selectedCategory by rememberSaveable {
        mutableStateOf(HomeCategoryModel.ALL)
    }

    HomeScreen(
        selectedTab = selectedTab,
        selectedCategory = selectedCategory,
        onTabClick = { selectedTab = it },
        onChipClick = { selectedCategory = it },
        onHeartClick = {},
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    selectedTab: HomeMenuModel,
    selectedCategory: HomeCategoryModel,
    onTabClick: (HomeMenuModel) -> Unit,
    onChipClick: (HomeCategoryModel) -> Unit,
    onHeartClick: (ProductModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = PLAYSOPTTheme.colors.white),
    ){
        item {
            MainTopBar(
                onSearchClick = {},
            )

            HomeTabRow(
                selectedTab = selectedTab,
                onTabClick = onTabClick,
            )

            HomeBanner()

            Column(
                modifier = Modifier.padding(vertical = 20.dp),
            ) {
                Text(
                    text = "김솝트님을 위한 추천 아이템",
                    style = PLAYSOPTTheme.typography.body.m18,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )

                Spacer(modifier = Modifier.height(12.dp))

                HomeChipRow(
                    selectedCategory = selectedCategory,
                    onChipClick = onChipClick,
                )
            }
        }

        items(productMockData.chunked(2)) { rowItems ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                rowItems.forEach { product ->
                    ProductCard(
                        product = product,
                        onHeartClick = { onHeartClick(product) },
                        modifier = Modifier.weight(1f),
                    )
                }

                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    PlaySoptTheme {
        var selectedTab by rememberSaveable { mutableStateOf(HomeMenuModel.HOME) }
        var selectedCategory by rememberSaveable { mutableStateOf(HomeCategoryModel.ALL) }

        HomeScreen(
            selectedTab = HomeMenuModel.HOME,
            selectedCategory = HomeCategoryModel.ALL,
            onTabClick = { selectedTab = it },
            onChipClick = { selectedCategory = it },
            onHeartClick = { },
        )
    }
}
