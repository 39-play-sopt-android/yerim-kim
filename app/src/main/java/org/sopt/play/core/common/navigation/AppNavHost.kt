package org.sopt.play.core.common.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.sopt.play.presentation.auth.login.LoginRoute
import org.sopt.play.presentation.auth.login.LoginViewModel
import org.sopt.play.presentation.auth.register.RegisterRoute
import org.sopt.play.presentation.auth.register.RegisterViewModel
import org.sopt.play.presentation.favorite.FavoriteRoute
import org.sopt.play.presentation.home.HomeRoute
import org.sopt.play.presentation.home.HomeViewModel
import org.sopt.play.presentation.main.StartDestination
import org.sopt.play.presentation.mypage.MyPageRoute
import org.sopt.play.presentation.search.SearchRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    startGraph: StartDestination,
    modifier: Modifier = Modifier,
) {
    val startDestination = when (startGraph) {
        StartDestination.AUTH -> AuthGraph
        StartDestination.MAIN -> MainGraph
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        modifier = modifier,
    ) {
        navigation<AuthGraph>(
            startDestination = Login
        ) {
            composable<Login> { backStackEntry ->
                val viewModel: LoginViewModel = viewModel(
                    viewModelStoreOwner = backStackEntry
                )

                LoginRoute(
                    viewModel = viewModel,
                    navigateToHome = {
                        navController.navigate(BottomBarRoute.Home) {
                            popUpTo<AuthGraph> { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                    navigateToRegister = { navController.navigate(Register) },
                )
            }

            composable<Register> { backStackEntry ->
                val viewModel: RegisterViewModel = viewModel(
                    viewModelStoreOwner = backStackEntry
                )

                RegisterRoute(
                    viewModel = viewModel,
                    navigateToLogin = { navController.popBackStack() }
                )
            }
        }

        navigation<MainGraph>(
            startDestination = BottomBarRoute.Home
        ) {
            composable<BottomBarRoute.Home> { backStackEntry ->
                val viewModel: HomeViewModel = viewModel(
                    viewModelStoreOwner = backStackEntry
                )

                HomeRoute(
                    viewModel = viewModel,
                    navigateToSearch = {
                        navController.navigate(Search)
                    },
                )
            }

            composable<BottomBarRoute.Favorite> {
                FavoriteRoute()
            }

            composable<BottomBarRoute.MyPage> {
                MyPageRoute()
            }

            composable<Search> {
                SearchRoute()
            }
        }
    }
}
