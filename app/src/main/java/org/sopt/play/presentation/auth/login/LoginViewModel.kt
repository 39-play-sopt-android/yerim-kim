package org.sopt.play.presentation.auth.login

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.R
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.common.util.getEmailError
import org.sopt.play.core.common.util.getPasswordError
import org.sopt.play.domain.repository.AuthRepository

class LoginViewModel(
    private val authRepository: AuthRepository,
) : BaseViewModel<LoginUiState, LoginUiEffect>(
    initialState = LoginUiState()
) {
    val emailState = TextFieldState()
    val passwordState = TextFieldState()

    init {
        viewModelScope.launch {
            snapshotFlow { emailState.text.toString() }
                .collect { email ->
                    updateState {
                        copy(
                            email = email,
                            emailError = getEmailError(email)
                        )
                    }
                }
        }

        viewModelScope.launch {
            snapshotFlow { passwordState.text.toString() }
                .collect { password ->
                    updateState {
                        copy(
                            password = password,
                            passwordError = getPasswordError(password)
                        )
                    }
                }
        }
    }

    fun onLoginClick() {
        val state = currentState
        val email = emailState.text.toString()
        val password = passwordState.text.toString()

        if (!state.isLoginEnabled || state.isLoading) return

        viewModelScope.launch {
            updateState { copy(isLoading = true) }

            try {
                handleLogin(email, password)
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
