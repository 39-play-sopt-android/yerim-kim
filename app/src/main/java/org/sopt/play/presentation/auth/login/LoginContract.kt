package org.sopt.play.presentation.auth.login

import androidx.annotation.StringRes
import org.sopt.play.core.base.BaseUiState

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    @param: StringRes val emailError: Int? = null,
    @param: StringRes val passwordError: Int? = null,
) : BaseUiState {
    val isLoginEnabled: Boolean
        get() = email.isNotEmpty() &&
                password.isNotEmpty() &&
                emailError == null &&
                passwordError == null
}

sealed interface LoginUiEffect {
    data object LoginFailure : LoginUiEffect
    data object LoginSuccess : LoginUiEffect
}
