package org.sopt.play.core.common.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.play.presentation.main.home.ui.HomeRoute
import org.sopt.play.presentation.auth.login.ui.LoginRoute
import org.sopt.play.presentation.auth.register.ui.RegisterRoute

@Composable
fun AppNavHost(
    modifier: Modifier,
) {
    val navController = rememberNavController()

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
    ) {
        composable<Home> {
            HomeRoute(
                modifier = modifier,
            )
        }

        composable<Login> {
            LoginRoute(
                onLoginClick = { _, _ ->
                    navController.navigate(Home)
                },
                onRegisterClick = {
                    navController.navigate(Register)
                },
                modifier = modifier,
            )
        }

        composable<Register> {
            RegisterRoute(
                onRegisterClick = { _, _ ->
                    navController.navigate(Login)
                },
                modifier = modifier,
            )
        }
    }
}
