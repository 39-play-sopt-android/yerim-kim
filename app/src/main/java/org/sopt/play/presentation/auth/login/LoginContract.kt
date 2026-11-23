package org.sopt.play.presentation.auth.login

import androidx.annotation.StringRes
import org.sopt.play.core.base.BaseUiState

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    @param:StringRes val emailError: Int? = null,
    @param:StringRes val passwordError: Int? = null,
    val isLoading: Boolean = false,
) : BaseUiState {
    val isLoginEnabled: Boolean
        get() = email.isNotBlank() &&
                password.isNotBlank() &&
                emailError == null &&
                passwordError == null
}

sealed interface LoginUiEffect {
    data class ShowToast(@param:StringRes val message: Int) : LoginUiEffect
    data object NavigateToHome : LoginUiEffect
}
