package org.sopt.play.core.common.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.play.R
import org.sopt.play.core.extension.toast
import org.sopt.play.presentation.main.home.ui.HomeRoute
import org.sopt.play.presentation.auth.login.ui.LoginRoute
import org.sopt.play.presentation.auth.register.ui.RegisterRoute
import org.sopt.play.presentation.main.favorite.ui.FavoriteRoute
import org.sopt.play.presentation.main.mypage.ui.MyPageRoute
import androidx.compose.ui.res.stringResource

private const val REGISTER_EMAIL = "register_email"
private const val REGISTER_PASSWORD = "register_password"

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarRoute.Home,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        modifier = modifier,
    ) {
        composable<Login> { backStackEntry ->
            val context = LocalContext.current
            val successMessage = stringResource(R.string.success_login)
            val errorMessage = stringResource(R.string.wrong_input)

            LoginRoute(
                onLoginClick = { email, password ->
                    val savedStateHandle = backStackEntry.savedStateHandle
                    val registerEmail = savedStateHandle.get<String>(REGISTER_EMAIL)
                    val registerPassword = savedStateHandle.get<String>(REGISTER_PASSWORD)

                    if (email == registerEmail && password == registerPassword) {
                        context.toast(successMessage)

                        navController.navigate(BottomBarRoute.Home) {
                            popUpTo<Login> {
                                inclusive = true
                            }
                        }
                    } else {
                        context.toast(errorMessage)
                    }
                },
                onRegisterClick = {
                    navController.navigate(Register)
                },
            )
        }

        composable<Register> {
            val context = LocalContext.current
            val successMessage = stringResource(R.string.success_register)

            RegisterRoute(
                onRegisterClick = { email, password ->
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.apply {
                            set(REGISTER_EMAIL, email)
                            set(REGISTER_PASSWORD, password)
                        }

                    context.toast(successMessage)
                    navController.popBackStack()
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
