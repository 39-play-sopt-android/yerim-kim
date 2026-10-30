package org.sopt.play.presentation.auth.login

import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordError

class LoginViewModel :
    BaseViewModel<LoginUiState, LoginUiEffect>(
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

    fun onLoginClick(registeredEmail: String?, registeredPassword: String?) {
        val state = currentState
        if (!state.isLoginEnabled) return
        val success = state.email == registeredEmail && state.password == registeredPassword

        sendEffect(if (success) LoginUiEffect.LoginSuccess else LoginUiEffect.LoginFailure)
    }
}
