package org.sopt.play.presentation.main.model

import androidx.annotation.DrawableRes
import org.sopt.play.R

enum class BottomBarItemModel(
    val label: String,
    @param:DrawableRes val defaultIcon: Int,
    @param:DrawableRes val filledIcon: Int,
) {
    HOME(
        label = "홈",
        defaultIcon = R.drawable.ic_home_default_24,
        filledIcon = R.drawable.ic_home_fill_24,
    ),
    FAVORITE(
        label = "찜",
        defaultIcon = R.drawable.ic_heart_default_24,
        filledIcon = R.drawable.ic_heart_fill_24,
    ),
    MY_PAGE(
        label = "마이페이지",
        defaultIcon = R.drawable.ic_user_default_24,
        filledIcon = R.drawable.ic_user_fill_24,
    ),
}
