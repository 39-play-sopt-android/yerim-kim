package org.sopt.play.presentation.auth.register

import org.sopt.play.core.base.BaseViewModel
import org.sopt.play.core.util.getEmailError
import org.sopt.play.core.util.getPasswordCheckError
import org.sopt.play.core.util.getPasswordError

class RegisterViewModel :
    BaseViewModel<RegisterUiState, Unit>(
        initialState = RegisterUiState(),
    ) {

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
}
