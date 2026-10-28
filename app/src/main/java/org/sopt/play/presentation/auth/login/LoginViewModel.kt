package org.sopt.play.presentation.auth.login

import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordError

class LoginViewModel :
    BaseViewModel<LoginUiState, Unit>(
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
}
