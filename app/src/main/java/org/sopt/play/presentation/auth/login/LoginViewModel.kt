package org.sopt.play.presentation.auth.login

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordError
import org.sopt.play.domain.repository.AuthRepository

class LoginViewModel(
    private val authRepository: AuthRepository
) : BaseViewModel<LoginUiState, LoginUiEffect>(
        initialState = LoginUiState()
    ) {
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
        if (!state.isLoginEnabled) return

        viewModelScope.launch {
            authRepository.login(state.email, state.password)
                .onSuccess { sendEffect(LoginUiEffect.LoginSuccess) }
                .onFailure { sendEffect(LoginUiEffect.LoginFailure) }
        }
    }
}
