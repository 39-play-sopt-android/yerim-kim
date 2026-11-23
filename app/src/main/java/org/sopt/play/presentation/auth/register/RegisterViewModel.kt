package org.sopt.play.presentation.auth.register

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.play.R
import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.common.util.getEmailError
import org.sopt.play.core.common.util.getPasswordCheckError
import org.sopt.play.core.common.util.getPasswordError
import org.sopt.play.data.di.RepositoryModule

class RegisterViewModel : BaseViewModel<RegisterUiState, RegisterUiEffect>(
    initialState = RegisterUiState(),
) {
    private val authRepository = RepositoryModule.authRepository
    val nameState = TextFieldState()
    val emailState = TextFieldState()
    val passwordState = TextFieldState()
    val passwordCheckState = TextFieldState()

    init {
        viewModelScope.launch {
            snapshotFlow { nameState.text.toString() }
                .collect { name ->
                    updateState {
                        copy(name = name)
                    }
                }
        }

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
            snapshotFlow {
                passwordState.text.toString() to passwordCheckState.text.toString()
            }.collect { (password, passwordCheck) ->
                updateState {
                    copy(
                        password = password,
                        passwordCheck = passwordCheck,
                        passwordError = getPasswordError(password),
                        passwordCheckError = getPasswordCheckError(password, passwordCheck),
                    )
                }
            }
        }
    }

    fun onRegisterClick() {
        val state = currentState
        if (!state.isRegisterEnabled || state.isLoading) return

        viewModelScope.launch {
            updateState { copy(isLoading = true) }
            try {
                handleRegister(state.name, state.email, state.password)
            } finally {
                updateState { copy(isLoading = false) }
            }
        }
    }

    private suspend fun handleRegister(
        name: String,
        email: String,
        password: String,
    ) {
        authRepository.register(name, email, password)
            .onSuccess {
                sendEffect(RegisterUiEffect.ShowToast(R.string.success_register))
                sendEffect(RegisterUiEffect.NavigateToLogin)
            }
    }
}
