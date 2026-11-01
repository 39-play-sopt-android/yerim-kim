package org.sopt.play.presentation.auth.register

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordCheckError
import org.sopt.play.core.util.getPasswordError
import org.sopt.play.data.di.RepositoryModule

class RegisterViewModel :
    BaseViewModel<RegisterUiState, RegisterUiEffect>(
        initialState = RegisterUiState(),
    ) {
    private val authRepository = RepositoryModule.authRepository

    fun onNameChange(name: String) {
        updateState {
            copy(name = name)
        }
    }

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
                passwordCheckError = getPasswordCheckError(password, passwordCheck),
            )
        }
    }

    fun onPasswordCheckChange(passwordCheck: String) {
        updateState {
            copy(
                passwordCheck = passwordCheck,
                passwordCheckError = getPasswordCheckError(password, passwordCheck),
            )
        }
    }

    fun onRegisterClick() {
        val state = currentState
        if (!state.isRegisterEnabled) return

        viewModelScope.launch {
            handleRegister(state.name, state.email, state.password)
        }
    }

    private suspend fun handleRegister(
        name: String,
        email: String,
        password: String,
    ) {
        authRepository.register(name, email, password)
            .onSuccess { sendEffect(RegisterUiEffect.RegisterSuccess) }
    }
}
