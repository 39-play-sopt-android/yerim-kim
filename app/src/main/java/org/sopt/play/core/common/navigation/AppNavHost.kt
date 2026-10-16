package org.sopt.play.core.common.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.play.presentation.main.home.ui.HomeRoute
import org.sopt.play.presentation.auth.login.ui.LoginRoute
import org.sopt.play.presentation.auth.register.ui.RegisterRoute
import org.sopt.play.presentation.main.favorite.ui.FavoriteRoute
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
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
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
                    navController.navigate(BottomBarRoute.Home)
                },
                onRegisterClick = {
                    navController.navigate(Register)
                },
            )
        }

        composable<Register> {
            RegisterRoute(
                onRegisterClick = { _, _ ->
                    navController.navigate(Login)
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
