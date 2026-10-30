package org.sopt.play.presentation.home

import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.data.mock.productMockData
import org.sopt.play.data.model.ProductModel
import org.sopt.play.presentation.home.model.HomeCategoryModel
import org.sopt.play.presentation.home.model.HomeMenuModel

class HomeViewModel :
    BaseViewModel<HomeUiState, HomeUiEffect>(
        initialState = HomeUiState(
            productList = productMockData,
        ),
    ) {
    fun onSearchClick() {
        sendEffect(HomeUiEffect.NavigateToSearch)
    }

    fun onTabClick(tab: HomeMenuModel) {
        updateState {
            copy(selectedTab = tab)
        }
    }

    fun onCategoryClick(category: HomeCategoryModel) {
        updateState {
            copy(selectedCategory = category)
        }
    }

    fun onHeartClick(product: ProductModel) {
        updateState {
            copy(
                productList = productList.map {
                    if (it == product) it.copy(isFavorite = !it.isFavorite) else it
                },
            )
        }
    }
}
