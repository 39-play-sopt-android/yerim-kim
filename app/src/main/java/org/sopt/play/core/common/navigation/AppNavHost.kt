package org.sopt.play.core.common.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.sopt.play.R
import org.sopt.play.core.extension.toast
import org.sopt.play.presentation.auth.login.LoginRoute
import org.sopt.play.presentation.auth.login.LoginUiEffect
import org.sopt.play.presentation.auth.login.LoginViewModel
import org.sopt.play.presentation.auth.register.RegisterRoute
import org.sopt.play.presentation.auth.register.RegisterUiEffect
import org.sopt.play.presentation.auth.register.RegisterViewModel
import org.sopt.play.presentation.favorite.FavoriteRoute
import org.sopt.play.presentation.home.HomeRoute
import org.sopt.play.presentation.mypage.MyPageRoute

private const val REGISTER_EMAIL = "register_email"
private const val REGISTER_PASSWORD = "register_password"

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph,
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
                val context = LocalContext.current
                val successMessage = stringResource(R.string.success_login)
                val errorMessage = stringResource(R.string.wrong_input)

                val viewModel: LoginViewModel = viewModel(
                    viewModelStoreOwner = backStackEntry
                )
                val state by viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(viewModel, backStackEntry) {
                    viewModel.uiEffect.collect { effect ->
                        when (effect) {
                            LoginUiEffect.LoginSuccess -> {
                                context.toast(successMessage)
                                navController.navigate(BottomBarRoute.Home) {
                                    popUpTo<AuthGraph> { inclusive = true }
                                    launchSingleTop = true
                                }
                            }

                            LoginUiEffect.LoginFailure -> context.toast(errorMessage)
                        }
                    }
                }

                LoginRoute(
                    state = state,
                    onEmailChange = viewModel::onEmailChange,
                    onPasswordChange = viewModel::onPasswordChange,
                    onLoginClick = {
                        val savedStateHandle = backStackEntry.savedStateHandle

                        viewModel.onLoginClick(
                            registeredEmail = savedStateHandle[REGISTER_EMAIL],
                            registeredPassword = savedStateHandle[REGISTER_PASSWORD],
                        )
                    },
                    onRegisterClick = {
                        navController.navigate(Register)
                    },
                )
            }

            composable<Register> { backStackEntry ->
                val context = LocalContext.current
                val successMessage = stringResource(R.string.success_register)

                val viewModel: RegisterViewModel = viewModel(
                    viewModelStoreOwner = backStackEntry
                )
                val state by viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(viewModel, backStackEntry) {
                    viewModel.uiEffect.collect { effect ->
                        when (effect) {
                            is RegisterUiEffect.RegisterSuccess -> {
                                navController.previousBackStackEntry
                                    ?.savedStateHandle
                                    ?.apply {
                                        set(REGISTER_EMAIL, effect.email)
                                        set(REGISTER_PASSWORD, effect.password)
                                    }

                                context.toast(successMessage)
                                navController.popBackStack()
                            }
                        }
                    }
                }

                RegisterRoute(
                    state = state,
                    onNameChange = viewModel::onNameChange,
                    onEmailChange = viewModel::onEmailChange,
                    onPasswordChange = viewModel::onPasswordChange,
                    onPasswordCheckChange = viewModel::onPasswordCheckChange,
                    onRegisterClick = viewModel::onRegisterClick
                )
            }
        }

        navigation<MainGraph>(
            startDestination = BottomBarRoute.Home
        ) {
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
}
