package org.sopt.play.presentation.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.domain.mock.productMockData
import org.sopt.play.domain.model.ProductModel
import org.sopt.play.domain.repository.AuthRepository
import org.sopt.play.presentation.home.model.HomeCategoryModel
import org.sopt.play.presentation.home.model.HomeMenuModel

class HomeViewModel(
    private val authRepository: AuthRepository,
) :
    BaseViewModel<HomeUiState, HomeUiEffect>(
        initialState = HomeUiState(
            productList = productMockData,
        ),
    ) {

    init {
        viewModelScope.launch {
            authRepository.currentUser.collect { user ->
                updateState {
                    copy(userName = user?.name)
                }
            }
        }
    }

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
                    if (it.productId == product.productId) it.copy(isFavorite = !it.isFavorite) else it
                },
            )
        }
    }
}
