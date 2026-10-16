package org.sopt.play.core.common.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.DefaultNavTransitions.enterTransition
import androidx.navigation.compose.DefaultNavTransitions.exitTransition
import androidx.navigation.compose.DefaultNavTransitions.popEnterTransition
import androidx.navigation.compose.DefaultNavTransitions.popExitTransition
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.play.presentation.main.home.ui.HomeRoute
import org.sopt.play.presentation.auth.login.ui.LoginRoute
import org.sopt.play.presentation.auth.register.ui.RegisterRoute
import org.sopt.play.presentation.main.favorite.ui.FavoriteRoute
import org.sopt.play.presentation.main.model.BottomBarItemModel
import org.sopt.play.presentation.main.mypage.ui.MyPageRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Login,
        enterTransition = {
            val initialIndex = BottomBarItemModel.entries.indexOfFirst {
                initialState.destination.hasRoute(it.route::class)
            }
            val targetIndex = BottomBarItemModel.entries.indexOfFirst {
                targetState.destination.hasRoute(it.route::class)
            }

            slideInHorizontally { width ->
                if (targetIndex > initialIndex) width else -width
            }
        },
        exitTransition = {
            val initialIndex = BottomBarItemModel.entries.indexOfFirst {
                initialState.destination.hasRoute(it.route::class)
            }
            val targetIndex = BottomBarItemModel.entries.indexOfFirst {
                targetState.destination.hasRoute(it.route::class)
            }

            slideOutHorizontally { width ->
                if (targetIndex > initialIndex) -width else width
            }
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        modifier = modifier,
    ) {
        composable<Login> {
            LoginRoute(
                onLoginClick = { _, _ ->
                    navController.navigate(BottomBarRoute.Home) {
                        popUpTo<Login> {
                            inclusive = true
                        }
                    }
                },
                onRegisterClick = {
                    navController.navigate(Register)
                },
            )
        }

        composable<Register> {
            RegisterRoute(
                onRegisterClick = { _, _ ->
                    navController.navigate(Login) {
                        popUpTo<Register> {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }

        composable<BottomBarRoute.Home> {
            HomeRoute()
        }

        composable<BottomBarRoute.Favorite> {
            FavoriteRoute()
        }

        composable<BottomBarRoute.MyPage> {
            MyPageRoute()
        }
    }
}
