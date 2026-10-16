package org.sopt.play.core.common.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Login

@Serializable
data object Register

@Serializable
sealed interface BottomBarRoute {
    @Serializable
    data object Home : BottomBarRoute

    @Serializable
    data object Favorite : BottomBarRoute

    @Serializable
    data object MyPage : BottomBarRoute
}
