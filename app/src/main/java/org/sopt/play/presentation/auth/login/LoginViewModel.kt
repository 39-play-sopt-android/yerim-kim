package org.sopt.play.presentation.auth.login

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.R
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.common.util.getEmailError
import org.sopt.play.core.common.util.getPasswordError
import org.sopt.play.data.di.RepositoryModule

class LoginViewModel : BaseViewModel<LoginUiState, LoginUiEffect>(
    initialState = LoginUiState()
) {
    private val authRepository = RepositoryModule.authRepository
    fun onEmailChange(email: String) {
        updateState {
            copy(
                email = email,
                emailError = getEmailError(email),
            )
        }
    }

    fun onPasswordChange(password: String) {
        updateState {
            copy(
                password = password,
                passwordError = getPasswordError(password),
            )
        }
    }

    fun onLoginClick() {
        val state = currentState
        if (!state.isLoginEnabled || state.isLoading) return

        viewModelScope.launch {
            updateState { copy(isLoading = true) }

            try {
                handleLogin(state.email, state.password)
            } finally {
                updateState { copy(isLoading = false) }
            }
        }
    }

    private suspend fun handleLogin(
        email: String,
        password: String,
    ) {
        authRepository.login(email, password)
            .onSuccess {
                sendEffect(LoginUiEffect.ShowToast(R.string.success_login))
                sendEffect(LoginUiEffect.NavigateToHome)
            }
            .onFailure {
                sendEffect(LoginUiEffect.ShowToast(R.string.wrong_input))
            }
    }
}
