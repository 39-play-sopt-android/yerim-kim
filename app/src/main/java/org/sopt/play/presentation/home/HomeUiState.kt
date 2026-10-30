package org.sopt.play.presentation.home

import org.sopt.play.core.base.BaseUiState
import org.sopt.play.data.model.ProductModel
import org.sopt.play.presentation.home.model.HomeCategoryModel
import org.sopt.play.presentation.home.model.HomeMenuModel

data class HomeUiState(
    val productList: List<ProductModel> = emptyList(),
    val selectedTab: HomeMenuModel = HomeMenuModel.HOME,
    val selectedCategory: HomeCategoryModel = HomeCategoryModel.ALL,
) : BaseUiState
