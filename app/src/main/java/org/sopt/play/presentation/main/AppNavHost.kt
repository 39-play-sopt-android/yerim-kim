package org.sopt.play.presentation.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.sopt.play.PlaySoptApplication
import org.sopt.play.core.common.navigation.AuthGraph
import org.sopt.play.core.common.navigation.BottomBarRoute
import org.sopt.play.core.common.navigation.Login
import org.sopt.play.core.common.navigation.MainGraph
import org.sopt.play.core.common.navigation.Register
import org.sopt.play.core.common.navigation.Search
import org.sopt.play.di.ViewModelFactory
import org.sopt.play.presentation.auth.login.LoginRoute
import org.sopt.play.presentation.auth.login.LoginViewModel
import org.sopt.play.presentation.auth.register.RegisterRoute
import org.sopt.play.presentation.auth.register.RegisterViewModel
import org.sopt.play.presentation.favorite.FavoriteRoute
import org.sopt.play.presentation.home.HomeRoute
import org.sopt.play.presentation.home.HomeViewModel
import org.sopt.play.presentation.mypage.MyPageRoute
import org.sopt.play.presentation.search.SearchRoute
import org.sopt.play.presentation.search.SearchViewModel

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
    val application = LocalContext.current.applicationContext as PlaySoptApplication
    val factory = remember(application) {
        ViewModelFactory(application.container)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { fadeIn(tween(200)) },
        exitTransition = { fadeOut(tween(200)) },
        popEnterTransition = { fadeIn(tween(200)) },
        popExitTransition = { fadeOut(tween(200)) },
        predictivePopEnterTransition = { fadeIn(tween(200)) },
        predictivePopExitTransition = { fadeOut(tween(200)) },
        modifier = modifier,
    ) {
        navigation<AuthGraph>(
            startDestination = Login
        ) {
            composable<Login> { backStackEntry ->
                val viewModel: LoginViewModel = viewModel(
//                    factory = factory,
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
//                    factory = factory,
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
//                    factory = factory,
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

            composable<Search> { backStackEntry ->
                val viewModel: SearchViewModel = viewModel(
                    factory = factory,
                    viewModelStoreOwner = backStackEntry
                )

                SearchRoute(
                    viewModel = viewModel,
                )
            }
        }
    }
}
