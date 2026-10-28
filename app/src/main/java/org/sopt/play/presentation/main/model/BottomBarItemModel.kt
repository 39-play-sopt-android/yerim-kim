package org.sopt.play.presentation.main.model

import androidx.annotation.DrawableRes
import org.sopt.play.R
import org.sopt.play.core.common.navigation.BottomBarRoute

enum class BottomBarItemModel(
    val label: String,
    @param:DrawableRes val defaultIcon: Int,
    @param:DrawableRes val filledIcon: Int,
    val route: BottomBarRoute,
) {
    HOME(
        label = "홈",
        defaultIcon = R.drawable.ic_home_default_24,
        filledIcon = R.drawable.ic_home_fill_24,
        route = BottomBarRoute.Home,
    ),
    FAVORITE(
        label = "찜",
        defaultIcon = R.drawable.ic_heart_default_24,
        filledIcon = R.drawable.ic_heart_fill_24,
        route = BottomBarRoute.Favorite,
    ),
    MY_PAGE(
        label = "마이페이지",
        defaultIcon = R.drawable.ic_user_default_24,
        filledIcon = R.drawable.ic_user_fill_24,
        route = BottomBarRoute.MyPage,
    ),
}
