package org.sopt.play.presentation.auth.register

import androidx.annotation.StringRes
import org.sopt.play.core.base.BaseUiState

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordCheck: String = "",
    @param:StringRes val emailError: Int? = null,
    @param:StringRes val passwordError: Int? = null,
    @param:StringRes val passwordCheckError: Int? = null,
    val isLoading: Boolean = false,
) : BaseUiState {
    val isRegisterEnabled: Boolean
        get() = name.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                passwordCheck.isNotBlank() &&
                emailError == null &&
                passwordError == null &&
                passwordCheckError == null
}

sealed interface RegisterUiEffect {
    data class ShowToast(@param:StringRes val message: Int) : RegisterUiEffect
    data object NavigateToLogin : RegisterUiEffect
}
